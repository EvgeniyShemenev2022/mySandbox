package com.Tasks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 * Напишите программу на Java для подсчета количества конкретных слов в строке, используя HashMap.
 * <p>
 * Реализовано два варианта с одинаковым функционалом.
 */
public class CountWordsHashMap {
    public static void main(String[] args) {

        String line = "This is the the the rhythm of of    my life";

        mapCounterStream(line);
        mapCounter(line);
    }

    /**
     * реализация потоком
     * @param line
     */
    public static void mapCounterStream(String line) {

        // the regular expression \s matches a single whitespace character,
        // while \s+ will match one or more whitespace characters.
        String[] words = line.split("\\s+");

        Map<String, Integer> mapping = Arrays.stream(words)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(a -> 1)));
        System.out.println(mapping);
    }

    /**
     * реализация ручной итерацией значения value
     * @param line
     */
    public static void mapCounter(String line) {

        String[] words = line.split("\\s+");
        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            if (map.containsKey(word)) {
                int count = map.get(word);
                map.put(word, count + 1);
            } else {
                map.put(word, 1);
            }
        }
        System.out.println(map);
    }
}
