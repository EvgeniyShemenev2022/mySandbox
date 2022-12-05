package com.leetCodeTasks;

import java.util.HashMap;
import java.util.Map;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * Given a roman numeral, convert it to an integer.
 *
 * Example 1:
 * Input: s = "III"
 * Output: 3
 * Explanation: III = 3.
 *
 * Example 3:
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class RomanToInteger_3 {

    public static void main(String[] args) {

        String x = "XXVII";
        String y = "XIX";
        String z = "III";
        String a = "VIV";
        String b = "MCMXCIV";
        String c = "LVIII";
        String g = "IX";

        int answer = romanToInt(g);
        System.out.println(answer);
    }

    /**
     * Входящее число в виде символов разбиваем на массив сток;
     * Соответственно ключу из карты - помещаем значение
     * каждого знака в массив (сохраняя порядок);
     * Итерируемся по массиву и выполняем условия, относительно
     * расположения каждой цифры;
     * Условие для последней цифры выполняется отдельно;
     */
    public static int romanToInt(String s) {

        int answer = 0;
        int[] array = new int[s.length()];

        Map<String, Integer> romanMap = new HashMap<>();
        romanMap.put("I", 1);
        romanMap.put("V", 5);
        romanMap.put("X", 10);
        romanMap.put("L", 50);
        romanMap.put("C", 100);
        romanMap.put("D", 500);
        romanMap.put("M", 1000);

        String[] romanNumb = s.split("");

        int index = 0;
        for (String numb : romanNumb) {
            array[index] = romanMap.get(numb);
            index++;
        }

        // если цифра одна
        if (array.length == 1){
            return array[0];
        }

        //сверяем предыдущее число с текущим
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] >= array[i]) {
                answer += array[i - 1];
            } else if (array[i - 1] < array[i]){
                answer +=  array[i] - array[i - 1];
                i++;  // важный момент, перешагиваем число, которое прибавили
            } else if (array[i - 1] == array[i]){
                answer += array[i - 1];
            }
            //условие для последнего числа
            if (i == array.length - 1 && array[array.length - 1] <= array[array.length - 1 - 1]){
                answer+= array[array.length - 1];
            }
        }
        return answer;
    }
}
