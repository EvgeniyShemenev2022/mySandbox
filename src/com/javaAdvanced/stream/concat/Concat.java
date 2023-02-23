package com.javaAdvanced.stream.concat;

import java.util.stream.Stream;

/**
 * метод .concat() возвращает stream, но после него
 * нельзя вызвать другой метод по цепочке;
 *
 * метод .concat() - статический;
 */
public class Concat {

    public static void main(String[] args) {

        Stream<Integer> stream1 = Stream.of(1,2,3,4,5,6);
        Stream<Integer> stream2 = Stream.of(1,2,3,4,5,6);


        Stream<Integer> stream3 = Stream.concat(stream1,stream2);
        stream3.forEach(System.out::print); // Output: 123456123456

    }
}
