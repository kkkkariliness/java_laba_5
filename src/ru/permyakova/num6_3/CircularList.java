package ru.permyakova.num6_3;

import java.util.List;

public class CircularList {
    public static <T> boolean hasEqual(List<T> list) {

        // Если список пуст или состоит из одного элемента
        if (list.isEmpty() || list.size() == 1) {
            return true;
        }

        // Проверяем пары элементов
        for (int i = 0; i < list.size(); i++) {
            int next = (i + 1) % list.size(); // Индекс следующего элемента по кругу
            if (list.get(i).equals(list.get(next))) {
                return true; // Найдено совпадение
            }
        }

        return false; // Совпадений не найдено
    }
}