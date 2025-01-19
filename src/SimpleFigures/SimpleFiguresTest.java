package SimpleFigures;

public class SimpleFiguresTest {
    public static void main(String[] args) {
        // Example 1: 2 Points and a Circle
        Point p1 = new Point(2, 3);
        Point p2 = new Point(4, 6);
        Circle c1 = new Circle(new Point(5, 5), 3);

        Aggregation aggregation1 = new Aggregation();
        aggregation1.addFigure(p1);
        aggregation1.addFigure(p2);
        aggregation1.addFigure(c1);

        System.out.println("Before Rotation (2 Points and a Circle):");
        System.out.println(aggregation1); 

        // Rotate 90 degrees to the right
        aggregation1.rotate(90, "right");

        System.out.println("\nAfter 90 degrees rotation (right):");
        System.out.println(aggregation1);  

        // Rotate 180 degrees to the left
        aggregation1.rotate(180, "left");

        System.out.println("\nAfter 180 degrees rotation (left):");
        System.out.println(aggregation1);  

        
        // Example 2: 5 Lines and a Point
        Point p3 = new Point(1, 1);
        Line l1 = new Line(new Point(0, 0), new Point(1, 2));
        Line l2 = new Line(new Point(1, 2), new Point(2, 0));
        Line l3 = new Line(new Point(0, 0), new Point(3, 3));
        Line l4 = new Line(new Point(1, 1), new Point(2, 2));
        Line l5 = new Line(new Point(2, 1), new Point(4, 2));

        Aggregation aggregation2 = new Aggregation();
        aggregation2.addFigure(p3);
        aggregation2.addFigure(l1);
        aggregation2.addFigure(l2);
        aggregation2.addFigure(l3);
        aggregation2.addFigure(l4);
        aggregation2.addFigure(l5);

        System.out.println("\nBefore Rotation (5 Lines and a Point):");
        System.out.println(aggregation2); 

        // Rotate 90 degrees to the right
        aggregation2.rotate(90, "right");

        System.out.println("\nAfter 90 degrees rotation (right):");
        System.out.println(aggregation2);  

        // Rotate 180 degrees to the left
        aggregation2.rotate(180, "left");

        System.out.println("\nAfter 180 degrees rotation (left):");
        System.out.println(aggregation2);  
    }
}
