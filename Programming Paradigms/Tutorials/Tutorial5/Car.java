package Tutorials.Tutorial5;

/**
 * Create a child class Car that will inherit all variables and methods of the Vehicle class.
 * Seating capacity default = 4
**/
public class Car extends Vehicle{

    int seatingCapacity;

    public Car(int maxSpeed, int mileage) {
        super(maxSpeed, mileage);
        seatingCapacity = 4;
    }

}
