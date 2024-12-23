package ru.permyakova.num7_1;

import java.util.List;

public class Polyline {
    private List<Point> points;

    public Polyline(List<Point> points) {
        this.points = points;
    }

    public String toString() {
        return "Линия [" + String.join(", ", points.stream().map(Point::toString).toList()) + "]";
    }
}