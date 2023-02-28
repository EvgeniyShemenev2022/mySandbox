package com.javaAdvanced.multithreading;


/**
 * DAEMON Thread
 * В этом примере показано, как установить поток в режим демона;
 * ! Важно вызвать метод .setDaemon(true) перед тем как поток будет запущен;
 *
 * Поток в режиме демона - выполняет фоновые задачи, это значит, что его работа автоматически
 * прекратится после завершения юзер-потоков;
 */
public class DaemonEx {

    public static void main(String[] args) {

        System.out.println("Main Thread Starts");

        UserThread userThread = new UserThread();
        userThread.setName("USER-thread");

        DaemonThread daemonThread = new DaemonThread();
        daemonThread.setName("DAEMON-thread");
        daemonThread.setDaemon(true);  // устанавливаем режим потока-демона

        userThread.start();
        daemonThread.start();

        System.out.println("Main Thread finished");
    }
}

// выводит буквы по порядку через секунду
class UserThread extends Thread {
    @Override
    public void run() {
        // получаем имя текущего потока + узнаем его статус в режиме демона (true/false)
        System.out.println(Thread.currentThread().getName() + " is Daemon " + isDaemon());
        for (char i = 'A'; i < 'J'; i++) {
            try {
                Thread.sleep(1000);
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// в режиме демона будет работать фоном, до тех пор пока юзер поток не завершит работу
class DaemonThread extends Thread {
    @Override
    public void run() {
        // получаем имя текущего потока + узнаем его статус в режиме демона (true/false)
        System.out.println(Thread.currentThread().getName() + " is Daemon " + isDaemon());
        for (int i = 1; i < 1000; i++) {
            try {
                Thread.sleep(200);
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}