package com.Shemenev;

import java.util.Arrays;
import java.util.Random;

/**
 * Merge Sorting
 * реализация сортировки слиянием;
 *
 * сложность алгоритма O(n log(n) )
 * неплохая производительность на больших массивах;
 */
public class MergeSortedSequences_2 {

    public static void main(String[] args) {

        int[] array_1 = new int[]{-1,8,4,16,2,-4,19,73,55,51,100};
        divider(array_1);
        System.out.println(Arrays.toString(array_1));

        int[] array_2 = new Random().ints(15, -15, 318).toArray();
        System.out.println(Arrays.toString(array_2));
        divider(array_2);
        System.out.println(Arrays.toString(array_2));
    }

    /**
     * 1) массив делится на два равных массива
     * 2) за счет рекурсии метод вызывается для каждой половины
     * до тех пор, пока в массивах не останется по одному эл-ту;
     * 3) вызывается метод слияния двух массивов;
     *
     * @param array сортируемый массив;
     */
    public static void divider(int[] array){
        int length = array.length;
        //условие остановки рекурсии
        if (length == 1) return;

        int mid = array.length / 2 ;
        int[] l = new int[mid];
        int[] r = new int[length - mid];
        for (int i = 0; i < mid; i++) {
            l[i] = array[i]; 
        }
        for (int i = mid; i < length; i++) {
            r[i - mid] = array[i];
        }
        divider(l);
        divider(r);
        merger(array, l, r);
    }

    /**
     * Метод выполняет слияние двух сортированных массивов в один;
     * Сложность алгоритма равно O(n + m);
     * Недостатки: На «почти отсортированных» массивах работает столь же долго, как на хаотичных;
     *
     * @param array_1 первый сортированный массив
     * @param array_2 второй сортированный массив
     * @param sortedArray массив, который необходимо сортировать
     */
    public static void merger(int[] sortedArray, int[] array_1, int[] array_2) {

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
    }
}
