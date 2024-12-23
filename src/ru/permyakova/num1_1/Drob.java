package ru.permyakova.num1_1;

public class Drob implements UseDrob {
    private int num; // Числитель
    private int denom; // Знаменатель

    // Геттеры
    public int getNum() {
        return num;
    }
    public int getDenom() {
        return denom;
    }

    // Создание дроби
    public Drob(int num, int denom) {
        if (denom == 0) throw new IllegalArgumentException("Знаменатель не может быть нулём!");
        if (denom < 0) {
            num = -num;
            denom = -denom;
        }
        this.num = num;
        this.denom = denom;
        DrobCache.updateCache(this);
    }

    // Сравнение двух дробей
    public boolean equal(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Drob other = (Drob) obj;
        return this.num == other.num && this.denom == other.denom;
    }

    @Override
    public void SetNum(int num) {
        this.num = num;
        DrobCache.updateCache(this);
    }

    @Override
    public void SetDenom(int denom) {
        if (denom == 0) throw new IllegalArgumentException("Знаменатель не может быть нулём!");
        if (denom < 0) {
            this.num = -this.num;
            denom = -denom;
        }
        this.denom = denom;
        DrobCache.updateCache(this);
    }

    @Override
    public double GetDec() {
        return DrobCache.getCache(this);
    }

    // Вывод
    public String toString() {
        return num + "/" + denom;
    }
}
