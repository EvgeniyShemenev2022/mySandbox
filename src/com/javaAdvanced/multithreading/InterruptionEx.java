package com.javaAdvanced.multithreading;

/**
 * Прерывание потоков;
 * метод .interrupt() дает сигнал потоку, что его хотят прервать;
 * метод if (isInterrupted()){code}  позволяет потоку проверить, хотят ли его прервать;
 * дальнейшую логику прерывания необходимо писать самостоятельно, она может быть разной
 * в зависимости от задач программы;
 *
 * методы sleep() и join() выбрасывают InterruptedException для того, чтобы предупредить
 * ситуацию в которой поток хотят прервать, а он в этот момент спит/ждет;
 */
public class InterruptionEx {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("main started");

        InterruptedThread interruptedThread = new InterruptedThread();
        interruptedThread.start();
        Thread.sleep(2000);

        // потоку дается сигнал, что его хотят прервать
        interruptedThread.interrupt();

        interruptedThread.join();
        System.out.println("main finished");
    }
}

class InterruptedThread extends Thread {

    @Override
    public void run() {
        double sqrtSum = 0;
        for (int i = 1; i < 1_000_000_000; i++) {
            // проверка на команду о прерывании
            if (isInterrupted()){
                System.out.println("Поток хотят прервать");
                return;
            }
            sqrtSum += Math.sqrt(i);  // находим сумму корней всех чисел
        }
        System.out.println(sqrtSum);
    }
}
