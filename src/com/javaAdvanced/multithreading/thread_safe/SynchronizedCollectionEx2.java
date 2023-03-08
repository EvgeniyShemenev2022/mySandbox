package com.javaAdvanced.multithreading.thread_safe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


/**
 * Если по коллекции проходится итератор, то его работу
 * необходимо помещать в блок synchronized() ДАЖЕ если
 * используется синхронизованная коллекция. В противном случае к
 * коллекции могут получить доступ одновременно несколько потоков,
 * что вызовет ConcurrentModificationException;
 * <p>
 * В этом примере демонстрируется правильный доступ к синхронизованному списку
 * двух потоков. Один из потоков реализует итератор, который заключен в блок synchronized(),
 * чтобы на время своей работы он ставил LOCK на доступ к коллекции.
 */
public class SynchronizedCollectionEx2 {

    public static void main(String[] args) throws InterruptedException {

        ArrayList<Integer> source = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            source.add(i);
        }

        List<Integer> synchList = Collections.synchronizedList(source);

        // простой вывод каждого элемента
        Runnable runnable1 = () -> {
            synchronized (synchList) {
                Iterator<Integer> iterator = synchList.iterator();
                while (iterator.hasNext()) {
                    System.out.println(iterator.next());
                }
            }
        };

        // удаление 10 элемента
        Runnable runnable2 = () -> synchList.remove(10);

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(synchList);
    }
}



