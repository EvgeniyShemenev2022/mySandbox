package com.javaAdvanced.multithreading;

/**
 * Условная задачка. Представляем магазин, в котором есть полка с хлебом.
 * Пекарь за день делает всего 10шт, а на полке помещается только 5шт.
 * Когда количество хлеба на полке становится меньше 5 Пекарь может докладывать его.
 *
 * метод wait() - освобождает монитор объекта, по которому синхронизированы потоки;
 * метод notify() -  пробуждает поток, который находился в состоянии ожидания.
 *
 * Без блока, синхронизация происходит по объекту this;
 * Оборачивать wait() в условие while(), а не IF() это рекомендация от Oracle;
 *
 */
public class WaitNotifyEx {

    public static void main(String[] args) {

        Market market = new Market();
        Baker baker = new Baker(market);
        Consumer consumer = new Consumer(market);

        Thread thread_1 = new Thread(baker);
        Thread thread_2 = new Thread(consumer);

        thread_2.start();
        thread_1.start();
    }
}

class Market {

    private int breadCount = 0;

    public synchronized void getBread(){
        while (breadCount < 1){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        breadCount--;
        System.out.println("Потребитель купил 1 хлеб. Количество хлеба сейчас = " + breadCount);
        notify();
    }


    public synchronized void putBread(){

        while (breadCount >= 5){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        breadCount++;
        System.out.println("Производитель добавил на витрину 1 хлеб; Сейчас на витрине " + breadCount + " шт.");
        notify();
    }
}

// пекарь производит только 10шт хлеба в день
class Baker implements Runnable{

    Market market;

    public Baker(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.putBread();
        }
    }
}

// покупатель покупает все что есть
class Consumer implements Runnable{

    Market market;

    public Consumer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.getBread();
        }
    }
}

