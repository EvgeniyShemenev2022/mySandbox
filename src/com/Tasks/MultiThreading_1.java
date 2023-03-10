package com.Tasks;

/**
 * демонстрация основных принципов многопоточности
 * в учебных целях (код без функционала);
 */
public class MultiThreading_1 {

    public static void main(String[] args) throws InterruptedException {

        //создание потока класса, унаследованного от Thread
        SupportThread thread = new SupportThread();
        thread.start();
        //создание потока класса, унаследованного от Thread
        SupportThread thread2 = new SupportThread();
        thread2.start();

        // метод останавливает поток
        System.out.println("I'm going to sleep");
        Thread.sleep(3000);
        System.out.println("I'm awake!!!");

        System.out.println("--------Message from main thread--------");

        //создание потока класса, унаследованного от интерфейса Runnable
        Thread thread3 = new Thread(new Runner());
        thread3.start();
    }
}

class SupportThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("One - Two - Three" + i);
        }
    }
}

class Runner implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("One - Two - Three" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
