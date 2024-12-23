package ru.permyakova.main;

import ru.permyakova.num1_1.*;
import ru.permyakova.num2_1.*;
import ru.permyakova.num3_3.*;
import ru.permyakova.num4_3.*;
import ru.permyakova.num5_3.*;
import ru.permyakova.num6_3.*;
import ru.permyakova.num7_1.*;
import ru.permyakova.num7_2.*;

import java.util.*;
import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {

        // ------------------------------------ 1 - 1 -------------------------------------------------

        out.println("------------------------------------ 1 - 1 -------------------------------------------------");
        Drob drob1 = new Drob(3, 4);
        Drob drob2 = new Drob(5, 48);

        // Вывод дробей
        out.println("Дробь 1: " + drob1);
        out.println("Дробь 2: " + drob2);

        // Получение вещественного значения
        out.println("Вещественное значение Дроби 1: " + drob1.GetDec());
        out.println("Вещественное значение Дроби 2: " + drob2.GetDec());

        // Сравнение дробей
        out.println("Дробь 1 равна Дроби 2: " + drob1.equals(drob2));

        // Установка отрицательного знаменателя
        drob1.SetDenom(-4);
        out.println("Дробь 1 после установки отрицательного знаменателя: " + drob1);
        out.println("Вещественное значение Дроби 1 после установки отрицательного знаменателя: " + drob1.GetDec());

        // ------------------------------------ 2 - 1 -------------------------------------------------

        out.println("------------------------------------ 2 - 1 -------------------------------------------------");
        List<Meowable> cats = new ArrayList<>();
        cats.add(new Cat("Сатана"));
        cats.add(new Cat("Пончик"));

        Funs.meowsCare(cats);

        // ------------------------------------ 3 - 3 -------------------------------------------------

        out.println("------------------------------------ 3 - 3 -------------------------------------------------");
        List<Integer> L1 = List.of(1, 3, 5, 7);
        List<Integer> L2 = List.of(2, 4, 6, 8);
        List<String> L1Strings = List.of("apple", "orange", "peach");
        List<String> L2Strings = List.of("banana", "kiwi", "plum");

        JoinList<Integer> integerJoinList = new JoinList<>();
        JoinList<String> stringJoinList = new JoinList<>();

        // Объединение списков чисел
        List<Integer> resultIntegers = integerJoinList.JoinLists(L1, L2);
        System.out.println("Объединённый список чисел: " + resultIntegers);

        // Объединение списков строк
        List<String> resultStrings = stringJoinList.JoinLists(L1Strings, L2Strings);
        System.out.println("Объединённый список строк: " + resultStrings);

        // ------------------------------------ 4 - 3 -------------------------------------------------

        out.println("------------------------------------ 4 - 3 -------------------------------------------------");
        String fileName = "test4.txt";
        List<String> topOfBest = SchoolFight.BestScore(fileName);

        // Если нет результатов, выходим
        if (topOfBest == null || topOfBest.isEmpty()) return;

        // Печать топ-3 участников
        System.out.println("Тройка лучших:");
        for (String e : topOfBest) System.out.println(e);

        // ------------------------------------ 5 - 3 -------------------------------------------------

        out.println("------------------------------------ 5 - 3 -------------------------------------------------");

        String fileName2 = "test5_2.txt";

        // Извлечение согласных
        Set<Character> consonants = Consonants.extract(fileName2);

        // Вывод
        if (consonants.isEmpty()) out.println("Все согласные встречаются более 1го раза");
        else out.println("Согласные только в одном слове: " + consonants);

        // ------------------------------------ 6 - 3 -------------------------------------------------

        out.println("------------------------------------ 6 - 3 -------------------------------------------------");

        List<Integer> intList = Arrays.asList(1, 2, 3, 1);
        System.out.println("Для списка чисел (1, 2, 3, 1): " + CircularList.hasEqual(intList));

        List<String> stringList = Arrays.asList("apple", "banana", "apple", "apple");
        System.out.println("Для списка строк(\"apple\", \"banana\", \"apple\", \"apple\"): " + CircularList.hasEqual(stringList));

        List<String> stringList2 = Arrays.asList("apple", "banana", "cherry");
        System.out.println("Для списка строк(\"apple\", \"banana\", \"cherry\"): " + CircularList.hasEqual(stringList2));

        // ------------------------------------ 7 - 1 -------------------------------------------------

        out.println("------------------------------------ 7 - 1 -------------------------------------------------");

        List<Point> points7 = List.of(
                new Point(7, -3),
                new Point(2, 3),
                new Point(7, 3),
                new Point(-6.5, -4),
                new Point(2, 3),
                new Point(2.3, 3.5)
        );

        Polyline polyline = PolylineBuilder.build(points7);
        out.println("Для списка точек: (7, -3),\n" +
                "                (2, 3),\n" +
                "                (7, 3),\n" +
                "                (-6.5, -4),\n" +
                "                (2, 3),\n" +
                "                (2.3, 3.5)");
        System.out.println(polyline);

        // ------------------------------------ 7 - 2 -------------------------------------------------

        out.println("------------------------------------ 7 - 2 -------------------------------------------------");

        String fileName3 = "test7_1.txt";
        Map<Integer, List<String>> groupPep = GroupPeople.group(fileName3);

        // Если нет результатов, выходим
        if (groupPep == null || topOfBest.isEmpty()) return;

        // Вывод
        System.out.println("Наш списочек:");
        groupPep.forEach((key, value) -> out.println(key + ": " + value));
    }
}