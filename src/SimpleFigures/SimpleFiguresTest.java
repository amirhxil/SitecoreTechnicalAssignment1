package SimpleFigures;

public class SimpleFiguresTest {
    public static void main(String[] args) {
        // Create some points
        Point p1 = new Point(1, 1);
        Point p2 = new Point(3, 4);
        System.out.println("Initial Points: " + p1 + ", " + p2);

        // Create and move a line
        Line line = new Line(p1, p2);
        System.out.println("Initial Line: " + line);
        line.move(2, 3);
        System.out.println("Line after moving: " + line);

        // Create and rotate a circle
        Circle circle = new Circle(new Point(5, 5), 10);
        System.out.println("Initial Circle: " + circle);
        circle.move(-2, -2);
        System.out.println("Circle after moving: " + circle);

        // Aggregation test
        Aggregation agg = new Aggregation();
        agg.addFigure(new Point(0, 0));
        agg.addFigure(new Circle(new Point(2, 2), 5));
        agg.addFigure(new Line(new Point(1, 1), new Point(4, 4)));
        System.out.println("Initial Aggregation: " + agg);
        agg.move(3, 3);
        System.out.println("Aggregation after moving: " + agg);
        agg.rotate(90);
        System.out.println("Aggregation after rotating: " + agg);
    }
}

