package be.intecbrussel;

import be.intecbrussel.Animal.Animal;
import be.intecbrussel.Care.Disease;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class AnimalShelter {

    private int animalID;

    private List<Animal> animals;



    public AnimalShelter() {
        animals = new ArrayList<>();
        animalID = 10; //better 0
    }

    public AnimalShelter(int animalID) {
        animals = new ArrayList<>();
        this.animalID = animalID;
    }


    public List<Animal> getAnimals() {
        return animals;
    }



    public void printAnimals(){
        animals.forEach(System.out::println);
    }

    public void sortAnimals(){
        animals = animals.stream()
                .sorted(Animal::compareTo)
                .toList();
    }

    public void sortAnimalsByName(){
        animals = animals.stream()
                .sorted(Comparator.comparing(a -> a.getName()))
                .toList();
    }

    public void sortAnimalsByAge(){
        animals = animals.stream()
                .sorted(Comparator.comparing(a -> a.getAge()))
                .toList();
    }

    public void  printAnimalNotVaccinated(Disease disease){
        animals.stream()
                .filter(a -> a.getIsVaccinated().get(disease).equals(false))
                .forEach(System.out::println);
    }

    public Optional<Animal> findAnimal(int animalNumber){
        Animal unknown = new Animal() {};
        return Optional.of(
                animals.stream()
                .filter(a -> a.getAnimalNumber() == animalNumber)
                        //.findFirst
                .findAny()
                .orElse(unknown)
        );
    }

    /* Hilal
    public Optional<Animal> findAnimal(int animalNumber){
        System.out.println("\n---------- Find Animal By Animal Number ----------");
        System.out.println("Searching for animal by animal number : " + animalNumber);

        Optional<Animal> foundByAnimalNumber = animals.stream()
                .filter(animal -> animal.getAnimalNumber() == animalNumber)
                .findFirst();

        if (foundByAnimalNumber.isPresent()){
            Animal animal = foundByAnimalNumber.get();
            System.out.println("Animal found : " + animal);
        } else {
            System.out.println("Animal with animal number " + animalNumber);
        }
        return foundByAnimalNumber;
    }
    */

    public Optional<Animal> findAnimal(String name) {
        Animal unknown = new Animal() {};
        return Optional.of(
                animals.stream()
                .filter(a -> a.getName().equals(name))
                .findAny()
                .orElse(unknown)
        );
    }

    /*Hilal
    public Optional<Animal> findAnimal(String name) {
        System.out.println("\n---------- Find Animal By Animal Name ----------");
        System.out.println("Searching for animal by animal name : " + name);
        Optional<Animal> foundByAnimalName = animals.stream()
                .filter(animal -> animal.getName().equals(name))
                .findFirst();

        if (foundByAnimalName.isPresent()) {
            Animal animal = foundByAnimalName.get();
            System.out.println("Animal found  : " + animal);
        } else {
            System.out.println("Animal with animal number " + name + " was not found.");
        }
        return foundByAnimalName;
    }
     */

    public void treatAnimal(int animalNumber){
        boolean isKnown = false;
        for (Animal animal : animals)
            if (animal.getAnimalNumber() == animalNumber) {
                animal.treatAnimal();
                isKnown = true;
            }
        if (!isKnown)
            System.out.println("De dier bestaat niet\n");
        /*Hilal
        animals.stream()
                .filter(animal -> animal.getAnimalNumber() == animalNumber)
                .forEach(Animal::treatAnimal);
         */
    }

    public void treatAnimal(String name){
        boolean isKnown = false;
        for (Animal animal : animals)
            if (animal.getName().equals(name)) {
                animal.treatAnimal();
                isKnown = true;
            }
        if (!isKnown)
            System.out.println("De dier bestaat niet\n");

        /*
        animals.stream()
                .filter(animal -> animal.getName().equals(name))
                .forEach(Animal::treatAnimal);
         */
    }

    public void treatAllAnimal(){
        for (Animal animal : animals)
            animal.treatAnimal();
    }

    public Animal findOldestAnimal(){
        return animals.stream()
                .max(Comparator.comparing(Animal::getAge)
                        //.orElse(null)
                .thenComparing(Animal::getAnimalNumber))
                .get();
    }

    public int countAnimals(){
        return animals.size();
    }

    public void addAnimal(Animal animal){
        animal.setAnimalNumber(animalID);
        animals.add(animal);
        animalID++;
    }

    /*
    @Override
    public String toString() {
        return "AnimalShelter{" +
                "animals=" + animals +
                ", animalId=" + animalId +
                '}';
    }
     */
}



/*
package intec.be;

        import java.util.*;

        import static java.util.Collections.min;

public class AnimalShelter1 {

    private List<Animal> animals=new ArrayList<>();
    private int animalId;

    public AnimalShelter1() {
        this.animalId=0;
    }

    public AnimalShelter1(int animalId) {
        this.animalId = animalId;
    }

    public AnimalShelter1(List<Animal> animals, int animalId) {
        this.animals = animals;
        this.animalId = animalId;
    }
    //getters en setters
    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public void printAnimals(){
        animals.forEach(System.out::println);
    }

    public void sortAnimals(){

        animals.sort(Comparator.comparing(Animal::getAnimalNumber).reversed());
    }

    public void sortAnimalsByName(){

        animals.sort(Comparator.comparing(Animal::getName));
    }
    public void sortAnimalsByAge(){

        animals.sort(Comparator.comparing(Animal::getAge));
    }

    public void printAnimalsNotVaccinated(Disease disease){
        animals.stream()
                .filter(animal -> !animal.getIsVaccinated().get(disease))
                .forEach(System.out::println);
    }

    public  Animal findAnimal(int animalNumber){

        return animals.stream()
                .filter(animal -> animal.getAnimalNumber()==animalNumber)
                .findFirst().
                orElse(null);


    }

    public  Animal findAnimal(String name){
        return animals.stream()
                .filter(animal -> animal.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);

    }
    public void treatAnimal(int animalNumber){

        animals.stream()
                .filter(animal -> animal.getAnimalNumber()==animalNumber)
                .findFirst().ifPresent(Treatable::treatAnimal);
    }
    public void treatAnimal(String name){
        animals.stream().
                filter(animal -> animal.getName().equalsIgnoreCase(name))
                .findFirst().ifPresent(Treatable::treatAnimal);
    }
    public void treatAllAnimals(){
        animals.forEach(Animal::treatAnimal);
    }
    public Animal findOldestAnimal(){

        return animals.stream()
                .max(Comparator.comparing(Animal::getAge))
                .orElse(null);
    }

    public int countAnimals(){

        long count = animals.stream().count();
        return (int) count;

    }

    public void addAnimal(Animal animal){
        animals.add(animal);
        animal.setAnimalNumber(animalId);
        animalId+=1;

    }


}
*/
