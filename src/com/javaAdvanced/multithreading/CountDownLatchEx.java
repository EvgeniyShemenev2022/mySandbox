package com.javaAdvanced.multithreading;

import java.util.concurrent.CountDownLatch;

/**
 * Синхронизатор CountDownLatch; latch - защелка/задвижка/запор;
 * <p>
 * countDownLatch.await() - Заставляет текущий поток ждать, пока latch не дойдет до нуля, если только поток
 * не будет прерван. Если текущий счетчик равен нулю, этот метод немедленно возвращает значение.
 * Если текущий счетчик больше нуля, то текущий поток становится отключенным для целей планирования потоков
 * и остается бездействующим.
 * <p>
 * В этом примере упрощенно демонстрируется, что друзья не смогут зайти в магазин,
 * до тех пор пока счетчик latch не достигнет 0, т.к. метод .await() вызван здесь (в методе .run())
 * раньше, чем строка (name + " is going to the market now.");
 * <p>
 * метод .getCount() работает соответственно названию;
 */
public class CountDownLatchEx {

    static CountDownLatch countDownLatch = new CountDownLatch(3); // изначальное число счетчика

    public static void marketStaffIsOnPlace() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Staff came to the market.");
        countDownLatch.countDown();
        System.out.println("count now: " + countDownLatch.getCount());
    }

    public static void everythingIsReady() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Let's open market!.");
        countDownLatch.countDown();
        System.out.println("count now: " + countDownLatch.getCount());
    }

    public static void openMarket() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("Market is opened. Welcome!");
        countDownLatch.countDown();
        System.out.println("count now: " + countDownLatch.getCount());
    }

    public static void main(String[] args) throws InterruptedException {

        Friend friend1 = new Friend("Jon", countDownLatch);
        Friend friend2 = new Friend("Lucy", countDownLatch);
        Friend friend3 = new Friend("Silvia", countDownLatch);
        Friend friend4 = new Friend("Ivan", countDownLatch);

        // каждый метод будет уменьшать значение счетчика на 1
        marketStaffIsOnPlace();
        everythingIsReady();
        openMarket();
    }
}

class Friend extends Thread {
    private String name;
    private CountDownLatch countDownLatch;

    public Friend(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;
        this.start();
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
            System.out.println(name + " is going to the market now.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



