package com.javaAdvanced.multithreading;

/**
 * Различные методы создания потоков:
 * 1. с помощью внутреннего класса
 * 2. лямбда выражением;
 */
public class Ex_3 {

    public static void main(String[] args) {

        // вариант 1
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("something");
            }
        }).start();


        // вариант 2
        new Thread(() -> System.out.println("something")).start();

    }
}
