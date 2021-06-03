package it.prova.springrestfarmmanager.web.api;

import it.prova.springrestfarmmanager.model.Animal;
import it.prova.springrestfarmmanager.service.animal.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("animal")
public class AnimalController {
    @Autowired
    private AnimalService service;

    @GetMapping("/all")
    public ResponseEntity<List<Animal>> getAll () {
        List<Animal> animales = service.listAll();
        return new ResponseEntity<>(animales, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Animal> get (@PathVariable("id") Long id) {
        Animal animal = service.caricaSingoloElemeno(id);
        return new ResponseEntity<>(animal, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Animal> add (@Valid @RequestBody Animal animal) {
        Animal animalInstance = service.inserisciNuovo(animal);
        return new ResponseEntity<>(animalInstance, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Animal> update(@Valid @RequestBody Animal animal, @PathVariable("id") Long id) {
        animal.setId(id);
        service.aggiorna(animal);
        Animal animalModificato = animal;
        return new ResponseEntity<>(animalModificato, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.rimuovi(service.caricaSingoloElemeno(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Animal>> getByName (@RequestParam("name") String name) {
        List<Animal> animal = service.trovaByNome(name);
        return new ResponseEntity<>(animal, HttpStatus.OK);
    }


}
