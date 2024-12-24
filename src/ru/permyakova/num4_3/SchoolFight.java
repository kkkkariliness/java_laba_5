package ru.permyakova.num4_3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class SchoolFight {
    public static List<String> BestScore(String fileName) {

        // Map для хранения имени участника и его общего балла
        Map<String, Integer> players = new HashMap<>();

        try {
            // Считываем строки из файла
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            int n = Integer.parseInt(lines.getFirst());

            // Проверяем, что n <= 100
            if (n > 100) {
                throw new IllegalArgumentException("Количество записей больше 100");
            }

            // Обрабатываем остальные строки
            for (int i = 1; i <= n; i++) {
                String line = lines.get(i);
                String[] parts = line.split(" ", 3); // Разделяем на Фамилия, Имя и Баллы
                if (parts.length < 3) continue; // Пропускаем строки с ошибками
                String fullName = parts[0] + " " + parts[1]; // Формируем ключ (Фамилия + Имя)
                String[] scores = parts[2].split(" "); // Разделяем баллы по видам спорта

                // Подсчитываем сумму баллов
                int totalScore = 0;
                for (String score : scores) {
                    try {
                        totalScore += Math.abs(Integer.parseInt(score));
                    } catch (NumberFormatException e) {
                        // Если балл некорректный, то считаем его равным нулю
                    }
                }

                // Сохраняем в Map
                players.put(fullName, totalScore);
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Некорректный формат данных: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }

        // Сортируем участников по набранным баллам в порядке убывания
        List<Map.Entry<String, Integer>> sortedPlayers = new ArrayList<>(players.entrySet());
        sortedPlayers.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Выводим тройку лучших (и тех, кто набрал равное количество баллов)
        int count = 0;
        int lastScore = -1;
        List<String> topOfBest = new ArrayList<>();

        for (Map.Entry<String, Integer> e : sortedPlayers) {
            if (count < 3 || e.getValue().equals(lastScore)) {
                topOfBest.add(e.getKey() + " " + e.getValue());
                if (!e.getValue().equals(lastScore)) {
                    count++;
                }
                lastScore = e.getValue();
            } else {
                break;
            }
        }

        // Возвращаем результат
        return topOfBest;
    }
}