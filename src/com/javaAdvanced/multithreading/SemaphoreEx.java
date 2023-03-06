package com.javaAdvanced.multithreading;

import java.util.concurrent.Semaphore;


/**
 * Синхронизатор Semaphore - (Hi Level CONCURRENCY);
 * <p>
 * Синхронизатор позволяет ограничить доступ к какому-то ресурсу. В конструктор
 * Semaphore нужно передавать количество потоков, которым он будет разрешать
 * одновременно использовать этот ресурс.
 */
public class SemaphoreEx {

    public static void main(String[] args) {

        // создание объекта семафора с 3 квотами для потоков
        Semaphore callBox = new Semaphore(3);

        Person person1 = new Person("Alla", callBox);
        Person person2 = new Person("Oleg", callBox);
        Person person3 = new Person("Nikolay", callBox);
        Person person4 = new Person("Alex", callBox);
        Person person5 = new Person("Peter", callBox);
    }
}

class Person extends Thread {

    String name;
    Semaphore semaphore;

    public Person(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
        this.start(); // запуск потока при создании объекта
    }

    @Override
    public void run() {
        System.out.println(name + " waiting");
        try {
            semaphore.acquire(); // получает разрешение от семафора на его блокировку
            System.out.println(name + " calling");
            Thread.sleep(2500);
            System.out.println(name + " finished calling");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release(); // освобождаем разрешение семафора
        }
    }
}


