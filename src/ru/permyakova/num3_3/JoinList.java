package ru.permyakova.num3_3;

import java.util.ArrayList;
import java.util.List;

public class JoinList<T extends Comparable<T>> {

    public List<T> JoinLists(List<T> L1, List<T> L2) {
        List<T> newList = new ArrayList<>();
        int i = 0, j = 0;

        // Проходим по обоим спискам, добавляя элементы в результирующий список в правильном порядке
        while (i < L1.size() && j < L2.size()) {
            if (L1.get(i).compareTo(L2.get(j)) <= 0) {
                newList.add(L1.get(i));
                i++;
            } else {
                newList.add(L2.get(j));
                j++;
            }
        }

        // Добавляем оставшиеся элементы из L1 (если они есть)
        while (i < L1.size()) {
            newList.add(L1.get(i));
            i++;
        }

        // Добавляем оставшиеся элементы из L2 (если они есть)
        while (j < L2.size()) {
            newList.add(L2.get(j));
            j++;
        }

        return newList;
    }
}