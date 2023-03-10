package com.Tasks;

import java.util.Arrays;

/**
 * Сортировка вставками является медленным алгоритмом
 * т.к. используется вложенный цикл.
 *
 * Применим лишь для малых наборов значений.
 * Асимптотическая сложность O(n^2)
 *
 * логика:
 * внешний цикл начинается с 1го индекса;
 * внутренний цикл итерируется от i до 0 (в обратную сторону),
 * таким образом мы сравниваем с текущим числом
 * все числа слева и меняем местами при необходимости.
 */
public class InsertionSort {
    public static void main(String[] args) {

        int[] array = new int[]{11, 37, 1, 2, 4, 46, 94, 16, 24, -4, 8, 8, 8, 26, 39, 31, 86, 12, 38};

        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {

                    array[j - 1] ^= array[j];
                    array[j] ^= array[j - 1];
                    array[j - 1] ^= array[j];
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
