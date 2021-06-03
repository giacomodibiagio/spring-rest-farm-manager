package it.prova.springrestfarmmanager.repository.animal;

import it.prova.springrestfarmmanager.model.Animal;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnimalRepository extends CrudRepository<Animal, Long> {

        List<Animal> findByName(String name);
}
