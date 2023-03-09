package com.javaAdvanced.multithreading.thread_safe;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Потокобезопасная очередь с ограниченным размером (capacity restrict);
 * Содержит все методы, присущие Queue;
 *
 */
public class ArrayBlockingQueueEx {

    public static void main(String[] args) {

        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(4);

        new Thread(() -> {
            int i = 0;
            while (true) {
                try {
                    queue.put(++i);
                    System.out.println("Producer added " + i + " " + queue);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    Integer i = queue.take();
                    System.out.println("Consumer added " + i + " " + queue);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // Output:
        /*Consumer added 1 []
        Producer added 1 []
        Producer added 2 [2]
        Producer added 3 [2, 3]
        Consumer added 2 [3]
        Producer added 4 [3, 4]
        Producer added 5 [3, 4, 5]
        Producer added 6 [3, 4, 5, 6]
        Consumer added 3 [4, 5, 6]
        Producer added 7 [4, 5, 6, 7]*/
    }
}
