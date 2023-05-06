package Lab7.Task4;

public class SportCar extends Car {

    private int speed;

    SportCar(String type, String model, String color, int speed) {
        super(type, model, color);
        this.speed = speed;
    }

    @Override
    int increaseSpeed(int increment) {
        this.speed += increment;
        return speed;
    }

    @Override
    int decreaseSpeed(int decrement) {
        this.speed -= decrement;
        return speed;
    }

    @Override
    int Break() {
        return this.speed = 0;
    }

}
