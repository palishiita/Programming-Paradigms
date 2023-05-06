package Lab7.Task2and3;

public class Triangle implements Shape {

    private final double base;
    private final double height;
    private final double hypotenuse;

    public Triangle(double a, double b, double c) {
        base = a;
        height = b;
        hypotenuse = c;
    }

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }

    public double getHypotenuse() {
        return hypotenuse;
    }

    @Override
    public double findArea() {
        return (getBase() * getHeight()) / 2;
    }

    @Override
    public double findPerimeter() {
        return getHeight() + getBase() + getHypotenuse();
    }

}
