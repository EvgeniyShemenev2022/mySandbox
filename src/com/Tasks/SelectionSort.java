package com.Tasks;

import java.util.Arrays;

/**
 * Сортировка выбором является медленным алгоритмом
 * т.к. используется вложенный цикл.
 *
 * Применим лишь для малых наборов значений.
 * Асимптотическая сложность O(n^2)
 *
 * логика:
 * вводим переменную "указатель", которая фиксирует индекс наименьшего числа;
 * проходим по списку и присваиваем указателю индекс меньшего числа;
 * в конце каждой итерации меняем местами
 * первое число в текущем цикле и число с индексом указателя;
 */
public class SelectionSort {
    public static void main(String[] args) {

        int[] array = new int[]{11, 37, 1, 2, 4, 46, 94, 16, 24, -4, 8, 8, 8, 26, 39, 31, 86, 12, 38};


        int min;
        int pos = 0; // фиксирует индекс наименьшего числа за проход
        for (int i = 0; i < array.length - 1; i++) {
            min = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (min > array[j]) {

                    min = array[j];
                    pos = j;
                    array[pos] = array[i];
                    array[i] = min;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
