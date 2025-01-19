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
            switch (figure.getClass().getSimpleName()) {
                case "Point":
                    ((Point) figure).move(dx, dy);
                    break;
                case "Line":
                    ((Line) figure).move(dx, dy);
                    break;
                case "Circle":
                    ((Circle) figure).move(dx, dy);
                    break;
            }
        }
    }

    public void rotate(int angle, String direction) {
        for (Object figure : figures) {
            switch (figure.getClass().getSimpleName()) {
                case "Point":
                    ((Point) figure).rotate(angle, direction);
                    break;
                case "Line":
                    ((Line) figure).rotate(angle, direction);
                    break;
                case "Circle":
                    ((Circle) figure).rotate(angle, direction);
                    break;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        int size = figures.size();
        for (int i = 0; i < figures.size(); i++) {
            result.append(figures.get(i).toString());
            if (i < size - 1) {
                result.append(", "); 
            } else {
                result.append("."); 
            }
        }
        return result.toString();
    }

}

