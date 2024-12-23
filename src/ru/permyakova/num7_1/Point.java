package ru.permyakova.num7_1;

import java.util.Objects;

public class Point {
    private final double x;
    private final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double GetX() {
        return this.x;
    }

    public double GetY() {
        return this.y;
    }

    public String toString() {
        return "{" + x + ";" + y + "}";
    }

    // Переопределённые классы equals и hashCode для корректной работы distinct
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return point.x == x && point.y == y;
    }

    public int hashCode() {
        return Objects.hash(x, y);
    }
}