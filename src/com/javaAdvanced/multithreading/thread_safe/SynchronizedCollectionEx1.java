package com.javaAdvanced.multithreading.thread_safe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Простой пример работы синхронизованного списка;
 * В момент обращения к такому списку на методе списка ставится LOCK,
 * запрещающий обращение к нему другим потокам; Как только работа метода
 * выполнена, LOCK снимается и начинает работу следующий поток.
 * <p>
 * Производительность таких коллекций (работы с ними) невысокая из-за необходимости
 * оборачивать каждый процесс.
 */
public class SynchronizedCollectionEx1 {

    public static void main(String[] args) throws InterruptedException {

        ArrayList<Integer> source = new ArrayList<>();
        // заполняем список
        for (int i = 0; i < 5; i++) {
            source.add(i);
        }

        // вместо уже созданного target можно (например) создать его в параметрах метода
        // .synchronizedList(new ArrayList<>())
        ArrayList<Integer> target = new ArrayList<>();
        List<Integer> synchList = Collections.synchronizedList(target);

        // два потока добавят все содержимое в синхронизованный список
        Runnable runnable = () -> {
            synchList.addAll(source);
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread2.start();
        thread1.start();

        thread1.join();
        thread2.join();

        System.out.println(synchList);
    }
}
