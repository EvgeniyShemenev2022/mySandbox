package com.javaAdvanced.multithreading;

import java.util.stream.Stream;

public class Ex_1 {

    public static void main(String[] args) {

        // эти потоки не синхронизированы
        AppThread1 appThread1 = new AppThread1();
        AppThread2 appThread2 = new AppThread2();

        appThread1.start();
        appThread2.start();
    }
}


class AppThread1 extends Thread {
    @Override
    public void run() {
        Stream<Integer> numbers = Stream.iterate(10, a -> a + 1).limit(100);
        numbers.forEach(System.out::println);
    }
}

class AppThread2 extends Thread {
    @Override
    public void run() {
        Stream<Integer> numbers = Stream.iterate(120, a -> a - 1).limit(100);
        numbers.forEach(System.out::println);
    }
}