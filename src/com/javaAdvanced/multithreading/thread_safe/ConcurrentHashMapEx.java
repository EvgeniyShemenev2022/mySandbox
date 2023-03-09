package com.javaAdvanced.multithreading.thread_safe;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;


/**
 * ConcurrentHashMap имплементирует интерфейс ConcurrentMap, который
 * наследуется от Map;
 * ConcurrentHashMap делит map на сегменты (по количеству бакетов), и предоставляет
 * доступ к коллекции всем потокам одновременно, НО в каждый сегмент единовременно
 * имеет доступ только один поток. Когда поток выполнил работу с определенным
 * сегментом, блок снимается и с этим сегментом начинает работу следующий поток.
 * Таким образом достигается неплохая производительность, выше чем у synchronizedMap;
 * <p>
 * Любое количество потоков может читать информацию из сегментов.
 * <p>
 * В этом примере демонстрируется, что вне зависимости от настроек задержки потоков, итератор
 * беспрепятственно просчитает все ключи, ДО или ПОСЛЕ изменения кол-ва элементов в коллекции
 * вторым потоком.
 */
public class ConcurrentHashMapEx {

    public static void main(String[] args) throws InterruptedException {

        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "Lenin");
        map.put(2, "Stalin");
        map.put(3, "Molotov");
        map.put(4, "Chernishevsky");
        map.put(5, "Trotsky");
        System.out.println(map);


        // проход по коллекции итератором
        Runnable runnable1 = () -> {
            Iterator<Integer> iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Integer i = iterator.next();
                System.out.println(i + ": " + map.get(i));
            }
        };

        // добавление эл-та с ключом 6
        Runnable runnable2 = () -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(6, "Khrushchev");
        };

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(map);
    }
}



