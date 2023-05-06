package Lab7.Task2and3;

public class Rectangle implements Shape {

    private final double height;
    private final double width;

    Rectangle(double H, double W) {
        this.height = H;
        this.width = W;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public double findArea() {
        return getHeight() * getWidth();
    }

    @Override
    public double findPerimeter() {
        return 2*(getWidth() + getHeight());
    }
}