package com.javaAdvanced.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Schedule - расписание;
 * Разобрано несколько методов ScheduledExecutorService:
 * <ul>
 *    <li> .schedule() - позволяет задать в параметрах время, перед стартом
 *    выполнения потока;
 *    <li> .scheduleAtFixedRate - используется для цикличного выполнения заданий в потоке,
 *    в параметрах задается время между стартом заданий;
 *    <li>.scheduleWithFixedDelay - параметр delay означает время между окончанием задания
 *    и началом нового(повторного);
 *    <li>  ExecutorService executorService = Executors.newCachedThreadPool()  - создание
 *    кэшированного тред-пула, который будет увеличивать количество потоков автоматически,
 *    в зависимости от входящих заданий; (необходимо почитать подробнее)
 * </ul>
 *
 *
 */
public class ThreadPoolEx_2 {

    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);

        // задаем время перед стартом потоков;
        service.schedule(new RunnableImpl200(), 3, TimeUnit.SECONDS);
        service.shutdown();


        // в этом методе настраиваем периодичность повторения заданного потока RunnableImpl200();
        service.scheduleAtFixedRate(new RunnableImpl200(), 3, 4, TimeUnit.SECONDS);
        Thread.sleep(15000); // иначе .shutdown сразу прекратит работу тред-пула;
        service.shutdown();


        // параметр delay(4) здесь означает время между окончанием задания и началом нового(повторного)
        service.scheduleWithFixedDelay(new RunnableImpl200(), 3, 4, TimeUnit.SECONDS);
        Thread.sleep(15000); // иначе .shutdown сразу прекратит работу тред-пула;
        service.shutdown();

        // ThreadPool который создает потоки по мере нагрузки (* почитать подробнее!)
        ExecutorService executorService = Executors.newCachedThreadPool();
    }
}

class RunnableImpl200 implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "  Started");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "  Finished");
    }
}