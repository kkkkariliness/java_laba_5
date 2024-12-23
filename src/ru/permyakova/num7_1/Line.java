package ru.permyakova.num7_1;

public class Line {
    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    public String toString() {
        return "Линия от " +  start + " до " + end;
    }
}