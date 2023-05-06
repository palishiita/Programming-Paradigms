package Lab7.Task1;

import java.util.Objects;

public class Dog {

    /*
    State: what the objects have, Dog has a name, age, color, etc.
    Behavior: what the objects do, Dog barks!!
    Identity: what makes them unique, (this is important when implementing the equals() method, to determine if the objects are different or not)
    every dog has a unique dogI
    */

    // fields
    private String name;
    private String color;
    private String breed;
    private int age;
    private double weight;
    private int uniqueDogID;

    public Dog(String name, String breed, String color, int age, double weight ) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.weight = weight;
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void bark() {
        System.out.println("woof, woof!");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dog dog)) return false;
        return getAge() == dog.getAge()
                && Double.compare(dog.weight, weight) == 0
                && Objects.equals(getName(), dog.getName())
                && Objects.equals(color, dog.color)
                && Objects.equals(breed, dog.breed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), color, breed, getAge(), weight);
    }


    public static void main(String[] args) {
        Dog dog1 = new Dog("snoopy", "poodle", "brown", 1, 2); // dog object from dog class
    }
}
