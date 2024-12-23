package ru.permyakova.num5_3;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Consonants {

    public static Set<Character> extract(String fileName) {

        Set<Character> Consonants = Set.of('б', 'в', 'г', 'д', 'ж', 'з', 'й', 'к', 'л', 'м', 'н', 'п', 'р', 'с', 'т', 'ф', 'х', 'ц', 'ч', 'ш', 'щ');
        Map<Character, Set<String>> consonantWords = new HashMap<>();
        Set<Character> result = new TreeSet<>(); // Для автоматической сортировки по алфавиту

        try {
            String text = Files.readString(Paths.get(fileName));
            // Разделяем текст на слова
            String[] words = text.toLowerCase().replaceAll("[^а-яё\\s]", "").split("\\s+");

            // Проходим по словам
            for (int i = 0; i < words.length; i++) {
                Set<Character> wordConsonants = new HashSet<>(); // Для хранения согласных в текущем слове

                // Проходим по буквам слова
                for (char c : words[i].toCharArray()) {
                    if (Consonants.contains(c)) {
                        wordConsonants.add(c); // Добавляем согласные
                    }
                }

                // Добавляем найденные согласные в карту
                for (char c : wordConsonants) {
                    consonantWords
                            .computeIfAbsent(c, k -> new HashSet<>())
                            .add(words[i]);
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
        // Ищем согласные, которые встречаются ровно в одном слове
        for (Map.Entry<Character, Set<String>> e : consonantWords.entrySet()) {
            if (e.getValue().size() == 1) {
                result.add(e.getKey()); // Если согласная встречается только в одном слове, добавляем её в результат
            }
        }

        return result;
    }
}