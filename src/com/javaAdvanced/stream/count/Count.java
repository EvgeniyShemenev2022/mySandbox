package com.javaAdvanced.stream.count;

import java.util.stream.Stream;


/**
 * метод count() используется для подсчета эл-в
 */
public class Count {

    public static void main(String[] args) {

        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 4, 4, 4, 4, 4, 5, 6);
        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 4, 4, 4, 4, 4, 5, 6);

        // количество элементов в потоке
        System.out.println(stream1.count());  // 11

        // количество уникальных элементов в потоке
        System.out.println(stream2.distinct().count());  // 6
    }
}
