package Lab7.Task2and3;

public class Square implements Shape {

    private final double side;

    public Square(double s) {
        side = s;
    }

    public double getSide() {
        return side;
    }

    @Override
    public double findArea() {
        return Math.pow(getSide(), 2);
    }

    @Override
    public double findPerimeter() {
        return 4 * getSide();
    }

}
