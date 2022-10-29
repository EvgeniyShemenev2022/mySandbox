package com.Shemenev;


/**
 * Напишите Java-программу, чтобы найти второе по величине число в массиве.
 * БЕЗ сортировки массива
 */
public class SearchingSecondValue {

    public static void main(String[] args) {

        int[] array = new int[]{15, 35, 11, -1, 5, 48, 68, 3, 55, 37, 4, 6, 1};
        searcher(array);
    }

    /**
     * находит второе по величине число в массиве
     * @param array
     */
    public static void searcher(int[] array) {

        int min = array[0];
        int second = array[0];
        int curr;
        for (int i = 1; i < array.length; i++) {
            curr = array[i];
            if (curr < min) {
                second = min;
                min = curr;
            } else if (curr < second) {
                second = curr;
            }
        }
        System.out.println("minimal number is -> " + min);
        System.out.println("second number after is -> " + second);
    }
}
