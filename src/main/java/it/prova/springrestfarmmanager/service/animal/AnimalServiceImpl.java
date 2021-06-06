package it.prova.springrestfarmmanager.service.animal;

import it.prova.springrestfarmmanager.model.Animal;
import it.prova.springrestfarmmanager.repository.animal.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AnimalServiceImpl implements AnimalService{
    @Autowired
    private AnimalRepository    repository;

    @Override
    public List<Animal> listAll() {
        return (List<Animal>) repository.findAll();
    }

    @Override
    public Animal caricaSingoloElemeno(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Animal aggiorna(Animal animalInstance) {
        return repository.save(animalInstance);
    }

    @Override
    public Animal inserisciNuovo(Animal animalInstance) {
        return repository.save(animalInstance);
    }

    @Override
    public void rimuovi(Animal animalInstance) {
        repository.delete(animalInstance);
    }

    @Override
    public List<Animal> trovaByNome(String name) {
        return repository.findByName(name);
    }
}
