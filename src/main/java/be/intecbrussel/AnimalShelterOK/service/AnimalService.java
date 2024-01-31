package be.intecbrussel.AnimalShelterOK.service;

import be.intecbrussel.AnimalShelterOK.model.Animal.OK.Animall;
import be.intecbrussel.AnimalShelterOK.model.Animal.OK.SortType;
import be.intecbrussel.AnimalShelterOK.repository.AnimalRepository;
import be.intecbrussel.animal.Animal;

import java.util.Comparator;
import java.util.List;

public class AnimalService {

    private AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository){
        this.animalRepository = animalRepository;
    }
    public void sortAnimalShelter(SortType sortType){
        List<Animall> animalList = animalRepository.getAnimals();

        switch (sortType){
            case AGE -> sortAnimalsByAge(animalList);
            case NAME -> sortAnimalsByName(animalList);
        }
    }

    //avec .sort(), on ne crée pas une nouvelle list(>< au stream)
    public void sortAnimalsByName(List<Animall> animalList){
        animalList.sort(Comparator.comparing(Animall::getName));
    }

    public void sortAnimalsByAge(List<Animall> animalList){
        animalList.sort(Comparator.comparing(Animall::getAge));
    }
}
