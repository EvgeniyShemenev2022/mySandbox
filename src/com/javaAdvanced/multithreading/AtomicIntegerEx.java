package com.javaAdvanced.multithreading;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * Без применения synchronized перед методом .increaseCount()
 * переменная count НЕ всегда будет равна 400; Начинается DATA RACE и
 * данные могут быть спутаны.
 * Однако, synchronized это весьма затратная операция, которая блокирует монитор, потом
 * обратно открывает его. Вместо этого разработчики советуют пользоваться классом AtomicInteger;
 * <p>
 * AtomicInteger - класс, который позволяет работать с целочисленными значениями int,
 * используя атомарные операции;
 * Имеет в арсенале много методов, некоторые из них:
 * .incrementAndGet();
 * .addAndGet(5);
 * .decrementAndGet();
 */
public class AtomicIntegerEx {

//    static int count = 0;

    static AtomicInteger counter = new AtomicInteger(0);

    // увеличивает переменную на 1 и возвращает новый результат
    public static void increaseCount() {
        counter.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new RunnableImpl15());
        Thread thread2 = new Thread(new RunnableImpl15());

        thread1.start();
        thread2.start();

        // не забываем остановить поток main
        thread1.join();
        thread2.join();

        System.out.println(counter);
    }
}

// каждый поток увеличивает count на 200;
class RunnableImpl15 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            AtomicIntegerEx.increaseCount();
        }
    }
}


