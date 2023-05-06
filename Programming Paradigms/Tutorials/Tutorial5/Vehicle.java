package Tutorials.Tutorial5;

/**
 * Task 5
 * Create Vehicle class with maxSpeed and mileage instance attributes and some methods
**/
public class Vehicle {

    int maxSpeed;
    int mileage;

    public Vehicle(int maxSpeed, int  mileage) {
        this.maxSpeed = maxSpeed;
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return "Vehicle: " + "maxSpeed: " + maxSpeed + ", mileage: " + mileage;
    }
}
