package com.javaAdvanced.multithreading;

/**
 * Представлен пример, как без статуса volatile у переменной b
 * метод main не закончит свою работу, т.к. значение b = true будет находиться
 * в кэш ядра, и изменение состояния этой переменной не будет известно потоку main;
 */
public class VolatileEx extends Thread{

     volatile boolean b = true;

    @Override
    public void run() {
        long counter = 0;
        while (b){
            counter++;
        }
        System.out.println("Loop is finished. Counter = " + counter);
    }

    public static void main(String[] args) throws InterruptedException {

        VolatileEx thread = new VolatileEx();
        thread.start();
        Thread.sleep(3000);
        System.out.println("Wake UP");
        thread.b = false;
        thread.join();
        System.out.println("End!");

    }
}
