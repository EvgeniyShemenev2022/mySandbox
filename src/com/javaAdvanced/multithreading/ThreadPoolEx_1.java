package com.javaAdvanced.multithreading;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * ThreadPool - множество потоков, каждый из которых предназначен для той или иной задачи;
 * В java, с thread pull удобнее всего работать посредством ExecutorService;
 * thread pull удобнее всего создавать, используя factory методы класса Executors;
 *
 * Метод .awaitTermination() заставляет ждать поток, в котором он объявлен либо окончания
 * указанного в параметрах времени, либо завершения работы тред-пула;
 */
public class ThreadPoolEx_1 {

    public static void main(String[] args) throws InterruptedException {

        // пример создания пула из нескольких потоков;
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // в пул из 5 потоков даем 10 задач
        for (int i = 0; i < 30; i++) {
            executorService.execute(new RunnableImpl100());
        }
        executorService.shutdown(); // закрытие тред пула

        // main не закончит работу раньше чем 5 сек или тред пул
        executorService.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("main Finished");
    }
}

class RunnableImpl100 implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() );
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
