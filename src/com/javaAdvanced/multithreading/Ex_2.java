package com.javaAdvanced.multithreading;

import java.util.stream.Stream;

public class Ex_2 {

    public static void main(String[] args) {

        Thread thread1 = new Thread(new AppThread3());
        Thread thread2 = new Thread(new AppThread4());

        thread1.start();
        thread2.start();

    }
}


class AppThread3 implements Runnable {
    @Override
    public void run() {
        Stream<Integer> numbers = Stream.iterate(10, a -> a + 1).limit(100);
        numbers.forEach(System.out::println);
    }
}

class AppThread4 implements Runnable {
    @Override
    public void run() {
        Stream<Integer> numbers = Stream.iterate(120, a -> a - 1).limit(100);
        numbers.forEach(System.out::println);
    }
}






