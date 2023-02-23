package com.javaAdvanced.stream.distinct;


import java.util.stream.Stream;

/**
 * distinct() оставляет уникальные значения, использую equals();
 */
public class Distinct {

    public static void main(String[] args) {

        Stream<Integer> stream1 = Stream.of(1, 1, 1, 2, 3, 4, 5, 6);
        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 4, 4, 4, 4, 4, 5, 6);


        Stream<Integer> stream3 = Stream.concat(stream1, stream2);
        stream3.distinct().forEach(System.out::print); // Output: 123456
    }
}
