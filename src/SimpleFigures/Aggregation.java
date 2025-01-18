package SimpleFigures;

import java.util.ArrayList;
import java.util.List;

public class Aggregation {
    List<Object> figures;

    public Aggregation() {
        figures = new ArrayList<>();
    }

    public void addFigure(Object figure) {
        figures.add(figure);
    }

    public void move(double dx, double dy) {
        for (Object figure : figures) {
            if (figure instanceof Point) {
                ((Point) figure).move(dx, dy);
            } else if (figure instanceof Line) {
                ((Line) figure).move(dx, dy);
            } else if (figure instanceof Circle) {
                ((Circle) figure).move(dx, dy);
            }
        }
    }

    public void rotate(double angle) {
        for (Object figure : figures) {
            if (figure instanceof Point) {
                ((Point) figure).rotate(angle);
            } else if (figure instanceof Line) {
                ((Line) figure).rotate(angle);
            } else if (figure instanceof Circle) {
                ((Circle) figure).rotate(angle);
            }
        }
    }

    @Override
    public String toString() {
        return "Aggregation{" + "figures=" + figures + '}';
    }
}

