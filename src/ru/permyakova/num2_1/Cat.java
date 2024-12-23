package ru.permyakova.num2_1;

import static java.lang.System.out;

public class Cat implements Meowable {
    private final String name;

    public Cat(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    public String toString() {
        return "Кот: " + name;
    }

    public void meow() {
        meow(1);
    }

    public void meow(int n) {
        StringBuilder meows = new StringBuilder();
        for (int i = 0; i < n; i++) {
            meows.append("мяу");
            if (i < n - 1) {
                meows.append("-");
            }
        }
        out.println(name + ": " + meows + "!");
    }
}