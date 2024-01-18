package be.intecbrussel.care;

import be.intecbrussel.Animal.Animal;
import be.intecbrussel.Animal.Cat;
import be.intecbrussel.Animal.Dog;
import be.intecbrussel.Animal.Monkey;
import be.intecbrussel.AnimalShelter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AnimalShelterTest {

    private AnimalShelter animalShelter;

    static Animal cat1 = new Cat(16,"Sam", true, true);
    static Animal dog1 = new Dog(23,"Voltaire", false, true);
    static Animal monkey1 = new Monkey(111,"Chichi", true, false);
    static Animal monkey2 = new Monkey(-2,"Alex", false, false);
    static Animal dog2 = new Dog(5,"Cinnamon", true, true);
    static Animal dog3 = new Dog(10, "Gipsy", false, false);
    static Animal monkey3 = new Monkey(32, "", true, true);
    static Animal cat2 = new Cat(12, "Petra", false, false);
    static Animal  cat3 = new Cat(3, "Jude", false, true);
    static Animal cat4 = new Cat(27, "Praline", true, false);



    {
        animalShelter = new AnimalShelter();

        animalShelter.addAnimal(cat1);
        animalShelter.addAnimal(dog1);
        animalShelter.addAnimal(monkey1);
        animalShelter.addAnimal(monkey2);
        animalShelter.addAnimal(dog2);
        animalShelter.addAnimal(dog3);
        animalShelter.addAnimal(monkey3);
        animalShelter.addAnimal(cat2);
        animalShelter.addAnimal(cat3);
        animalShelter.addAnimal(cat4);
    }

    /*
    @Test
    public void SortedTest(){

        animalShelter.sortAnimalsByName();
        Animal result = animalShelter.getAnimals().get(1);

        Animal expectedAnimal = monkey2;

        Assertions.assertEquals(expectedAnimal,result);
    }
    */

    @ParameterizedTest
    @MethodSource("sortedByNameFactory")
    public void sortAnimalByNameTest(int index, Animal expectedName){
        animalShelter.sortAnimalsByName();

        Animal result = animalShelter.getAnimals().get(index);

        Assertions.assertEquals(expectedName,result);
    }

    public static Stream<Arguments> sortedByNameFactory(){


        return Stream.of(
                    Arguments.of(5,cat3)
        );

    }

    @ParameterizedTest
    @MethodSource("sortedByAgeFactory")
    public void sortAnimalByAbeTest(int index, Animal expectedName){
        animalShelter.sortAnimalsByAge();

        Animal result = animalShelter.getAnimals().get(index);

        Assertions.assertEquals(expectedName,result);
    }

    public static Stream<Arguments> sortedByAgeFactory() {


        return Stream.of(
                Arguments.of(0, monkey2),
                Arguments.of(5, cat1),
                Arguments.of(9, monkey1)
        );

    }

    @ParameterizedTest
    @MethodSource("sortedFactory")
    public void sortAnimalTest(int index, Animal expectedName){
        animalShelter.sortAnimals();

        Animal result = animalShelter.getAnimals().get(index);

        Assertions.assertEquals(expectedName,result);
    }

    public static Stream<Arguments> sortedFactory() {


        return Stream.of(
                Arguments.of(0, cat1),
                Arguments.of(4, dog2),
                Arguments.of(9, cat4)
        );
    }


    @ParameterizedTest
    @MethodSource("findAnimalByNameFactory")
    public void findAnimalByNameTest (int animalNumber, String expectedAnimal){
        Optional<Animal> result = animalShelter.findAnimal(animalNumber);

        String result1 = result.stream()
                .map(Animal::getName)
                .collect(Collectors.joining());

        Assertions.assertEquals(expectedAnimal, result1);
    }

    public static Stream<Arguments> findAnimalByNameFactory(){

        return Stream.of(
                Arguments.of(12, monkey1.getName()),
                Arguments.of(2, new Monkey().getName()),
                Arguments.of(19, cat4.getName())
        );
    }

    @ParameterizedTest
    @MethodSource("findAnimalByNumberFactory")
    public void findAnimalByNumberTest (String animalName, String expectedAnimal){
        Optional<Animal> result = animalShelter.findAnimal(animalName);

        String result1 = result.stream()
                .map(Animal::getName)
                .collect(Collectors.joining());

        Assertions.assertEquals(expectedAnimal, result1);
    }

    public static Stream<Arguments> findAnimalByNumberFactory(){

        return Stream.of(
                Arguments.of("Chichi", monkey1.getName()),
                Arguments.of("Rien", new Cat().getName()),
                Arguments.of("Voltaire", dog1.getName())
        );
    }

    @ParameterizedTest
    @MethodSource("treatAnimalByNumberFactory")
    public void treatAnimalByNumberTest (int animalNumber, boolean expectedClean){



        animalShelter.treatAnimal(animalNumber);
        boolean resultClean = animalShelter.findAnimal(animalNumber).get().isClean();

        Assertions.assertEquals(expectedClean, resultClean);

    }

    public static Stream<Arguments> treatAnimalByNumberFactory(){

        return Stream.of(
                Arguments.of(12, true),
                Arguments.of(15, true)
        );
    }

    @ParameterizedTest
    @MethodSource("treatAnimalByNameFactory")
    public void treatAnimalByNameTest (String animalName, boolean expectedClean){

        animalShelter.treatAnimal(animalName);
        boolean resultClean = animalShelter.findAnimal(animalName).get().isClean();

        Assertions.assertEquals(expectedClean, resultClean);
    }

    public static Stream<Arguments> treatAnimalByNameFactory(){

        return Stream.of(
                Arguments.of("Cinnamon", true),
                Arguments.of("Gipsy", true),
                Arguments.of(" ", false)
        );
    }

    @ParameterizedTest
    @MethodSource("treatAllAnimalFactory")
    public void treatAllAnimalTest (String animalName, boolean expectedClean){

        animalShelter.treatAllAnimal();
        boolean resultClean = animalShelter.findAnimal(animalName).get().isClean();

        Assertions.assertEquals(expectedClean, resultClean);
    }

    public static Stream<Arguments> treatAllAnimalFactory(){

        return Stream.of(
                Arguments.of("Sam", true),
                Arguments.of("Petra", true),
                Arguments.of(null, false)
        );
    }

    @Test
    public void findOldestAnimalTest(){

        Animal result = animalShelter.findOldestAnimal();
        Animal expectedAnimal = monkey1;
        Assertions.assertEquals(expectedAnimal, result);


    }

    @Test
    public void countAnimalTest(){

        int result = animalShelter.countAnimals();
        int expectedCount = 10;
        Assertions.assertEquals(expectedCount, result);
    }

    @Test void addAnimalTest(){

        animalShelter.addAnimal(new Dog());
        int result = animalShelter.countAnimals();
        int expectedCount = 11;
        Assertions.assertEquals(expectedCount, result);
    }




    /*
    boolean result = switch (disease) {
        case 1 -> monkey1.getIsVaccinated().get(Disease.POLIO);
        case 2 -> monkey1.getIsVaccinated().get(Disease.FLUE);
        case 3 -> monkey1.getIsVaccinated().get(Disease.HEPATITISA);
        case 4 -> monkey1.getIsVaccinated().get(Disease.CHICKENPOCKS);
        default -> false;
      }


        @ParameterizedTest
    @MethodSource("treatAnimalByNumberFactory")
    public void treatAnimalByNumberTest (int animalNumber, boolean expectedClean, boolean expectedTreated){

        animalShelter.treatAnimal(animalNumber);
        Animal animal = animalShelter.findAnimal(animalNumber).get();

        boolean resultClean = animalShelter.findAnimal(animalNumber).get().isClean();
        if (animal instanceof Dog)
        boolean resultTreated = animalShelter.findAnimal(animalNumber).get().i

        Assertions.assertEquals(expectedClean, resultClean);
        Assertions.assertEquals(expectedTreated, result);

        boolean resultCleanBefore = animalShelter.findAnimal(animalNumber).get().isClean();
        //Assertions.assertEquals(expectedClean, resultCleanBefore);
    };*/

}
