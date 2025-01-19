package SimpleFigures;

public class Point {
    double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void move(double dx, double dy) {
        x += dx;
        y += dy;
    }

    public void rotate(int angle, String direction) {
        double radians = Math.toRadians(angle);
        if ("left".equals(direction)) {
            radians = -radians;
        }
        double newX = x * Math.cos(radians) - y * Math.sin(radians);
        double newY = x * Math.sin(radians) + y * Math.cos(radians);
        x = newX;
        y = newY;
    }

    @Override
    public String toString() {
        return String.format("Point(%.2f, %.2f)", x, y);
    }
}