package be.intecbrussel.Animal;

public class Cat extends Animal {

    private boolean hasLongNails;


    public Cat() {
        super();
        hasLongNails = false;
    }

    public Cat(int age, String name, boolean isClean, boolean hasLongNails) {
        super(age, name, isClean);
        this.hasLongNails = hasLongNails;
    }

    /* Hilal
    public boolean isHasLongNails() {
        return hasLongNails;
    }

    public void setHasLongNails(boolean hasLongNails) {
        this.hasLongNails = hasLongNails;
    }
    */

    @Override
    public void treatAnimal() {
        super.treatAnimal();
        System.out.println(hasLongNails ? "De cat heeft lange nagels en we gaan het behandelen\n" :
                "De cat heeft geen lange nagels\n");
        if (hasLongNails)
            hasLongNails = false;
    }

    /* Hilal
    public void treatAnimal(){
        super.setClean(true);
        this.setHasLongNails(false);
    }
    */


    @Override
    public String toString() {
        return "\nCAT\n" +
                super.toString()
                + "\nHasLongNails= " + hasLongNails;

    }
}
