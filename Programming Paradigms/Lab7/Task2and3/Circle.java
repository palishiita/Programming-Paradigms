package Lab7.Task2and3;

public class Circle implements Shape {

    private final double radius;

    Circle(double r) {
        radius = r;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double findArea() {
        return Math.PI * Math.pow(getRadius(), 2);
    }

    @Override
    public double findPerimeter() {
        return 2 * Math.PI * getRadius();
    }
}
