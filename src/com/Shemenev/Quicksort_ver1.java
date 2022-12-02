package com.Shemenev;

import java.util.Arrays;
import java.util.Random;


/**
 * Быстрая сортировка является стандартным решением в
 * стоковых методах сортировки.
 * Состоит из двух частей:
 * 1) сдвигает элементы влево\вправо относительно указателя;
 * 2) рекурсивно делит массив на 2 части относительно указателя;
 *
 * Сложность алгоритма O(log(n))
 */
public class Quicksort_ver1 {

    public static void main(String[] args) {

        int[] array = new Random().ints(15, -30, 180).toArray();
        System.out.println("BEFORE  " + Arrays.toString(array));

        quickSort(array, 0, array.length - 1 );
        System.out.println("AFTER  " + Arrays.toString(array));
    }

    private static void quickSort(int[] array, int start, int end) {
        if (start >= end) return;

        int pivot = partition(array, start, end);
        quickSort(array, start, pivot - 1);
        quickSort(array, pivot + 1, end );
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int index = start - 1;
        // {4, 3, 5, 6, 11}
        for (int j = start; j <= end; j++){
            if (array[j] < pivot ){
                index++;

                // по какой то причине побитовое смещение не работает
                int swapTemp = array[index];
                array[index] = array[j];
                array[j] = swapTemp;
            }
        }
        index++;

        // по какой то причине побитовое смещение не работает
        int swapTemp = array[index];
        array[index] = array[end];
        array[end] = swapTemp;

        return index;
    }
}
