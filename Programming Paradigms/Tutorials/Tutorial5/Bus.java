package Tutorials.Tutorial5;

/**
 * Create a child class Bus that will inherit all the variables and methods of the Vehicle class.
 * Seating capacity default = 50
**/
public class Bus extends Vehicle{

    protected int maxSpeed;
    protected int mileage;
    protected int seatingCapacity;

    public Bus(int maxSpeed, int mileage) {
        super(maxSpeed, mileage);
        seatingCapacity = 50;
    }

    public Bus(int maxSpeed, int mileage, int seatingCapacity) {
        super(maxSpeed, mileage);
        this.seatingCapacity = seatingCapacity;
    }
    
    


}
