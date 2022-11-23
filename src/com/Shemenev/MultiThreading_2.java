package com.Shemenev;

import java.util.Scanner;

/**
 * демонстрация основных принципов многопоточности
 * в учебных целях (код без функционала);
 */
public class MultiThreading_2 {

    public static void main(String[] args) throws InterruptedException {

        // запускаем поток
        Thread2 thread2 = new Thread2();
        thread2.start();

        // поток main ожидает ввода строки
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        // т.к. строка введена поток main продолжает выполнять команды
        thread2.shutdown();
        scanner.close();
    }
}

class Thread2 extends Thread {

    // volatile позволяет избежать когерентности кэш-памяти
    // эта переменная не будет помещаться в кэш отдельного ядра процессора
    private volatile boolean running = true;

    @Override
    public void run() {
        while (running) {
            System.out.println("Go - Go!");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void shutdown() {
        this.running = false;
    }
}

