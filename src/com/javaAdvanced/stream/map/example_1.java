package com.javaAdvanced.stream.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Метод map преобразует значение таким образом, как будет задано в условии;
 * работает на основе ф.интерфейса Functional:
 * Это промежуточная операция.
 */
public class example_1 {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Hallo");
        list.add("Welcome");
        list.add("Hi");
        list.add("See you");
        list.add("Good Evening");

        // пример без использования stream
        for (int i = 0; i < list.size(); i++) {
            list.set(i, String.valueOf(list.get(i).length()));
        }
        System.out.println(list);

        // получаем список из длин слов (при этом список1 никак не изменяется)
        List<Integer> list2 = list.stream().map(String::length).toList();
        System.out.println(list2);

        // работа с простым массивом (с изменением)
        int[] array = {2, 4, 6, 8, 10, 15, 20};
        array = Arrays.stream(array).map(e -> e % 3 == 0 ? e / 3 : e).toArray();
        System.out.println(Arrays.toString(array));

    }
}
