package com.TasksFromBook;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Глава 1 задача № 1;
 * <p>
 * Написать программу, которая подсчитывает повторяющиеся символы в заданной строке.
 * <p>
 * Вариант 1 - применяя stream;
 * Вариант 2 - цикл for;
 */
public class Task1_1 {

    private static String line = "Шла Маша по шоссе и сосала сушку";

    public static void main(String[] args) {

        System.out.println(countingCharsMap(line));
        System.out.println(countingCharsMap2(line));

        // Output:
        // { =6, с=5, у=2, ш=3, Ш=1, а=5, е=1, и=1, к=1, л=2, М=1, о=3, п=1}
        // { =6, с=5, у=2, ш=3, Ш=1, а=5, е=1, и=1, к=1, л=2, М=1, о=3, п=1}
    }

    public static Map<Character, Long> countingCharsMap(String line) {

        Map<Character, Long> answerMap = new HashMap<>();

        // для работы с нестандартными символами использовать метод .codePoints()
        answerMap = line.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Character::charValue, Collectors.counting()));
        return answerMap;
    }

    public static Map<Character, Integer> countingCharsMap2(String str) {

        Map<Character, Integer> resultMap = new HashMap<>();

        for (char ch : str.toCharArray()) {
            resultMap.compute(ch, (k, v) -> v == null ? 1 : ++v);
        }
        return resultMap;
    }
}
