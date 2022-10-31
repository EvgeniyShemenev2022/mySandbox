package com.Shemenev;

import java.util.Arrays;

/**
 * Сортировка пузырьком не очень эффективный алгоритм,
 * т.к. используется вложенный цикл.
 *
 * Применим лишь для малых наборов значений.
 * Асимптотическая сложность O(n^2)
 *
 *
 * логика:
 * каждый элемент в массиве сравнивается со следующим,
 * если текущий элемент больше следующего - меняем местами
 * длину цикла можно уменьшать с конца, т.к. самые
 * большие значения уже перенесены в конец.
 */
public class BubleSort {

    public static void main(String[] args) {

        int[] array = new int[]{11, 37, 1, 2, 4, 46, 94, 16, 24, -4, 8, 8 , 8,  26, 39, 31, 86, 12, 38};


        for (int i = 0; i < array.length - 1 - i; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {

                    array[j] ^= array[j + 1];
                    array[j + 1] ^= array[j];
                    array[j] ^= array[j + 1];
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
