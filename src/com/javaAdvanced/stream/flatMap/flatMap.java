package com.javaAdvanced.stream.flatMap;

import java.util.List;

/**
 * Позволяет "выровнять" многомерные массивы, вложенные списки и пр. в
 * один поток, с которым доступна последующая работа;
 * много примеров:
 * https://mkyong.com/java8/java-8-flatmap-example/#what-is-flatmap
 */
public class flatMap {

    public static void main(String[] args) {

        // простые списки
        List<Integer> list1 = List.of(1,2,3,4,5,6,7,8,9);
        List<Integer> list2 = List.of(11,22,33,44,55,66,77,88,99);
        List<Integer> list3 = List.of(12,23,34,45,56,67,78,89,90);

        // набор списков
        List<List<Integer>> allLists = List.of(list1, list2, list3);

        allLists.stream()
                .flatMap(list -> list.stream()) // или  Collection::stream
                .filter(a -> a > 10)
                .map(b -> b*2)
                .sorted()
                .forEach(System.out::println);
    }
}
