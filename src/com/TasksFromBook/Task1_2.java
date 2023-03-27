package com.TasksFromBook;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Поиск первого неповторяющегося символа.
 * Написать программу, которая возвращает первый неповторяющийся (некратный) символ в заданной строке.
 *
 * 1) с помощью цикла for;
 * 2) с помощью Stream;
 */
public class Task1_2 {

    private static String str = "ZZZZZZZZZZZZoonnnnnnnaaaaaaaaaxmma";

    public static void main(String[] args) {

        System.out.println(findRepeatingChar(str));
        System.out.println(findRepeatingCharStreamApi(str));

    }

    public static char findRepeatingChar(String str) {

        Map<Character, Integer> map = new LinkedHashMap<>();

        for (char ch : str.toCharArray()) {
            map.compute(ch, (k, v) -> v == null ? 1 : ++v);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return Character.MIN_VALUE;
    }


    public static String findRepeatingCharStreamApi(String str) {

        Map<Integer, Long> map = str.codePoints()
                .mapToObj(cp -> cp)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        int cp = map.entrySet().stream()
                .filter(e -> e.getValue() == 1L)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(Integer.valueOf(Character.MIN_VALUE));

        return String.valueOf(Character.toChars(cp));
    }
}
