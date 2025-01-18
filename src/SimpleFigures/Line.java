package SimpleFigures;

public class Line {
    Point start, end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public void move(double dx, double dy) {
        start.move(dx, dy);
        end.move(dx, dy);
    }

    public void rotate(double angle) {
        start.rotate(angle);
        end.rotate(angle);
    }

    @Override
    public String toString() {
        return String.format("Line[%s -> %s]", start, end);
    }
}
