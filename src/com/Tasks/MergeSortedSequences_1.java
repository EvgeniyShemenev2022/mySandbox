package com.Tasks;

import java.util.Arrays;

/**
 * Merge Sorting (merge two sorted sequences)
 */
public class MergeSortedSequences_1 {

    public static void main(String[] args) {

        int[] array_1 = new int[]{1, 5, 8, 13, 23, 48, 90};
        int[] array_2 = new int[]{-2, 3, 6, 14, 25, 44, 46, 47};

        int[] array_3 = new int[]{1, 5, 8, 13, 23, 23, 48, 90};
        int[] array_4 = new int[]{-2, 3, 3, 6, 14, 25, 44, 46, 48, 47, 156,158, 164};

        System.out.println(Arrays.toString(merger(array_1, array_2)));
        System.out.println(Arrays.toString(merger(array_3, array_4)));

    }

    /**
     * Метод выполняет слияние двух сортированных массивов в один;
     * Сложность алгоритма равно O(n + m);
     * Недостатки: На «почти отсортированных» массивах работает столь же долго, как на хаотичных;
     *
     * @param array_1 первый сортированный массив
     * @param array_2 второй сортированный массив
     * @return новый отсортированный массив
     */
    public static int[] merger(int[] array_1, int[] array_2) {

        int[] sortedArray = new int[array_1.length + array_2.length];
        int x = 0;
        int y = 0;

        for (int i = 0; i < sortedArray.length; i++) {
            if (x >= array_1.length){
                sortedArray[i] = array_2[y];
                y++;
            }else if (y >= array_2.length){
                sortedArray[i] = array_1[x];
                x++;
            }else if (array_1[x] > array_2[y]){
                sortedArray[i] = array_2[y];
                y++;
            }else {
                sortedArray[i] = array_1[x];
                x++;
            }
        }
        return sortedArray;
    }
}
