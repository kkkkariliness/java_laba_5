package ru.permyakova.num7_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class GroupPeople {

    // Метод для преобразования имени
    private static String nameTrans(String name) {
        if (name == null || name.isEmpty()) return name;
        return Character.toUpperCase(name.charAt(0)) + name.substring(1);
    }

    public static Map<Integer, List<String>> group(String fileName) {

        Map<Integer, List<String>> groupedPeople = null;

        try {
            // Читаем строки из файла и обрабатываем их
            groupedPeople = Files.lines(Paths.get(fileName))
                    .map(String::trim) // Убираем пробелы по краям
                    .filter(line -> line.contains(":")) // Оставляем только строки с форматом "имя:номер"
                    .map(line -> line.split(":")) // Разбиваем строку на части
                    .filter(parts -> parts.length == 2 && !parts[1].isBlank()) // Убираем строки без номера
                    .collect(Collectors.groupingBy(
                            parts -> Integer.parseInt(parts[1]), // Группируем по номеру
                            Collectors.mapping(
                                    parts -> nameTrans(parts[0].toLowerCase()), // Преобразуем имя
                                    Collectors.toList() // Собираем в список
                            )
                    ));

        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Некорректный формат данных: " + e.getMessage());
        }
        return groupedPeople;
    }
}
