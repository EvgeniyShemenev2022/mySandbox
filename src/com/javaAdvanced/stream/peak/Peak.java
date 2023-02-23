package com.javaAdvanced.stream.peak;

import java.util.stream.Stream;

/**
 * метод peak() можно использовать в диагностических целях,
 * просматривая промежуточные операции в потоке;
 */
public class Peak {

    public static void main(String[] args) {

        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 4, 4, 4, 4, 4, 5, 6);

        // выводим все элементы, до того, как они преобразуются в count()
        System.out.println(stream1.distinct().peek(System.out::print).count());

    }
}
