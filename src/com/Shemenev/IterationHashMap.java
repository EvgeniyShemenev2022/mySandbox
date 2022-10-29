package com.Shemenev;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Напишите Java-программу для итерации объекта
 * типа HashMap с использованием цикла while и улучшенного цикла for.
 */
public class IterationHashMap {
    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Stalin");
        map.put(2, "Lenin");
        map.put(3, "Mao_Dzedun");

        // вариант № 1
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry current = (Map.Entry) iterator.next();
            System.out.println("key -> " + current.getKey() + " value -> " + current.getValue());
        }
        System.out.println("\n\n");

        // вариант № 2
        for (Map.Entry current : map.entrySet()) {
            System.out.println("key -> " + current.getKey() + " value -> " + current.getValue());
        }
    }
}
