package com.javaAdvanced.multithreading.thread_safe;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * CopyOnWriteArrayList следует использовать, когда необходимо обеспечить
 * потокобезопасность. В алгоритме небольшое количество изменений(вставок) и
 * большое количество по чтению эл-в.
 * <p>
 * При операциях, изменяющих содержимое коллекции, происходит полное копирование
 * списка (новый при каждой операции). Таким образом лучше ограничиться чтением.
 */
public class CopyOnWriteArrayListEx {

    public static void main(String[] args) throws InterruptedException {

        CopyOnWriteArrayList<String> source = new CopyOnWriteArrayList<>();
        source.add("Lenin");
        source.add("Stalin");
        source.add("Molotov");
        source.add("Chernishevsky");
        source.add("Trotsky");
        System.out.println(source);

        Runnable runnable1 = () -> {
            Iterator<String> iterator = source.iterator();
            while (iterator.hasNext()) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(iterator.next());
            }
        };

        Runnable runnable2 = () -> {
            source.add("Voroshilov");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            source.remove(3);
        };


        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(source);
    }
}



