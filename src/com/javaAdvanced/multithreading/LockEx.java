package com.javaAdvanced.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * Пример использования интерфейса Lock и класса ReentrantLock;
 * Назначение этого класса такое же, как и у метода synchronized();
 *      Выполняется блокировка монитора, на время работы одного из потоков;
 * Однако необходимо помнить об открытии замка методом .unlock() в блоке  finally {};
 * Иначе, последующие потоки не смогут занять монитор объекта.
 *
 */
public class LockEx {

    public static void main(String[] args) {

        Call call = new Call();

        // примеры создания потоков без анонимного класса (много лишнего кода)
        Thread thread1 = new Thread(() -> call.mobileCall());
        Thread thread2 = new Thread(call::skypeCall);
        Thread thread3 = new Thread(() -> call.telegramCall());

        thread1.start();
        thread2.start();
        thread3.start();

    }
}


class Call {
    private Lock lock = new ReentrantLock();

    public void mobileCall() {
        lock.lock();
        try {
            System.out.println("Mobile call start");
            Thread.sleep(3000);
            System.out.println("Mobile call finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void skypeCall() {
        lock.lock();
        try {
            System.out.println("Skype call start");
            Thread.sleep(3000);
            System.out.println("Skype call finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void telegramCall() {
        lock.lock();
        try {
            System.out.println("Telegram call start");
            Thread.sleep(3000);
            System.out.println("Telegram call finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}