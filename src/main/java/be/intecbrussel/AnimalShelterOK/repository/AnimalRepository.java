package be.intecbrussel.AnimalShelterOK.repository;

import be.intecbrussel.AnimalShelterOK.model.Animal.OK.Animall;

import java.util.ArrayList;
import java.util.List;

public class AnimalRepository {

    private List<Animall> shelterAnimals = new ArrayList<>();

    {
        shelterAnimals.add(new Animall("Bobby", 52, 1));
        shelterAnimals.add(new Animall("Jean-Neymar", 10, 2));
        shelterAnimals.add(new Animall("PotatoSalad", 30, 3));
        shelterAnimals.add(new Animall("Anastasia", 3, 4));
    }
    public List<Animall> getAnimals(){
        return shelterAnimals;
    }


    /*
    public List<Animall> getAnimals(){

        if (shelterAnimals.contains(new Animall())){
            throw new RuntimeException("animal already exist");
        }
        return shelterAnimals;
    }

    boolean addAnimal(Animall animall){
        if (shelterAnimals.contains(animall)){
            return false;
        }
        shelterAnimals.add(animall);
        return true;
    }
     */


}
