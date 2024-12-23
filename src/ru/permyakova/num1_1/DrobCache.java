package ru.permyakova.num1_1;

public class DrobCache  {

    private static Drob cachedDrob = null;
    private static Double cachedDec = null;

    // Получение закэшированного значения или вычисление нового
    public static double getCache(Drob drob) {
        if (!drob.equals(cachedDrob)) {
            cachedDrob = drob;
            cachedDec = (double) drob.getNum() / drob.getDenom();
        }
        return cachedDec;
    }

    // Обновление кэша при изменении дроби
    public static void updateCache(Drob drob) {
        cachedDrob = drob;
        cachedDec = (double) drob.getNum() / drob.getDenom();
    }
}