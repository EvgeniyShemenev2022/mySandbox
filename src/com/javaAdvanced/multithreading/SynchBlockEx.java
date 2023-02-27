package com.javaAdvanced.multithreading;

/**
 * На телефоне три приложения, по которым может поступить звонок;
 * Нужно сделать так, чтобы в момент разговора другие приложения ждали;
 * Без блока  synchronized (SynchBlockEx.class) {}  методы будут срабатывать одновременно;
 * Точкой синхронизации можно сделать и объект любого другого класса;
 *
 * ! Конструктор синхронизировать нельзя, т.к. JVM гарантирует, что конструктор может быть
 * обработан лишь одним конструктором.
 */
public class SynchBlockEx {

//    final static Object lock = new Object();   // можно синхронизировать методы по этому объекту

    void mobileCall() {
        synchronized (SynchBlockEx.class) {
            System.out.println("CALLING! mobileCall Start!");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Mobile call END!");
        }
    }

    void skypeCall() {
        synchronized (SynchBlockEx.class) {
            System.out.println("CALLING! skypeCall Start!");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("skypeCall call END!");
        }
    }

    void telegramCall() {
        synchronized (SynchBlockEx.class) {
            System.out.println("CALLING! telegramCall Start!");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("telegramCall call END!");
        }
    }

    public static void main(String[] args) {

        Thread thread_1 = new Thread(new RunnableImplMobile());
        Thread thread_2 = new Thread(new RunnableImplSkype());
        Thread thread_3 = new Thread(new RunnableImplTelegram());

        thread_1.start();
        thread_2.start();
        thread_3.start();
    }
}

class RunnableImplMobile implements Runnable {
    @Override
    public void run() {
        new SynchBlockEx().mobileCall();
    }
}

class RunnableImplSkype implements Runnable {
    @Override
    public void run() {
        new SynchBlockEx().skypeCall();
    }
}

class RunnableImplTelegram implements Runnable {
    @Override
    public void run() {
        new SynchBlockEx().telegramCall();
    }
}