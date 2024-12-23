package ru.permyakova.num7_1;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PolylineBuilder {
    public static Polyline build(List<Point> points) {
        List<Point> resPoints = points.stream()
                .distinct() // Убираем точки с одинаковыми координатами
                .map(point -> new Point(point.GetX(), Math.abs(point.GetY()))) // Отрицательные Y делаем положительными
                .sorted(Comparator.comparingDouble(Point::GetX)) // Сортируем по X
                .collect(Collectors.toList()); // Собираем в список

        return new Polyline(resPoints);
    }
}