package ru.permyakova.num2_1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

public class Funs {
    public static void meowsCare(List<Meowable> meowables) {

        // Хранение счётчиков каждого объекта
        Map<Meowable, CountMeow> counters = new HashMap<>();
        for (Meowable meowable : meowables) {
            CountMeow counter = new CountMeow();
            for (int i = 0; i < 5; i++) {
                meowable.meow();
                counter.plus();
            }
            counters.put(meowable, counter);
        }

        // Вывод
        for (Map.Entry<Meowable, CountMeow> с : counters.entrySet()) {
            out.println(с.getKey() + " мяукал " + с.getValue().getCount() + " раз");
        }
    }
}