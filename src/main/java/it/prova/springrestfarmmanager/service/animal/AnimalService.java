package it.prova.springrestfarmmanager.service.animal;

import it.prova.springrestfarmmanager.model.Animal;

import java.util.List;

public interface AnimalService {

    public List<Animal> listAll();

    public Animal caricaSingoloElemeno(Long id);

    public Animal aggiorna(Animal animalInstance);

    public Animal inserisciNuovo(Animal animalInstance);

    public void rimuovi(Animal animalInstance);

    public List<Animal> trovaByNome(String name);
}
