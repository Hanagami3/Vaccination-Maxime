package be.intecbrussel.AnimalShelterOK.model.Animal.OK;

public class Animall {

    String Name;
    int age;
    int id;

    public Animall(String name, int age, int id) {
        Name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
