package Lab7.Task4;

abstract class Car {

    private String type;
    private String model;
    private String color;
    private int speed;

    Car(String type, String model, String color) {
        this.type = type;
        this.model = model;
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    abstract int increaseSpeed(int increment);
    abstract int decreaseSpeed(int decrement);
    abstract int Break();

}
