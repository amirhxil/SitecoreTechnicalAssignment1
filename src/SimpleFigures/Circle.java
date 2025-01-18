package SimpleFigures;

public class Circle {
    Point center;
    double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public void move(double dx, double dy) {
        center.move(dx, dy);
    }

    public void rotate(double angle) {
        // A circle doesn't change on rotation.
    }

    @Override
    public String toString() {
        return String.format("Circle[Center=%s, Radius=%.2f]", center, radius);
    }
}
