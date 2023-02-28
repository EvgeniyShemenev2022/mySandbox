package com.javaAdvanced.multithreading;

/**
 * При попытке синхронизироваться по монитору более чем одного объекта,
 * есть вероятность устроить ситуацию DeadLock; в этом случае потоки
 * будут ждать друг друга бесконечно долго.
 */
public class DeadLockEx {

    // объекты для синхронизации (имя любое)
    public static final Object deadLock = new Object();
    public static final Object deadLock2 = new Object();

    public static void main(String[] args) {

        Thread10 thread10 = new Thread10();
        Thread20 thread20 = new Thread20();
        thread10.start();
        thread20.start();
    }
}

// блок синхронизации по 1 объекту, затем по второму
class Thread10 extends Thread{
    @Override
    public void run() {
        System.out.println("TR-10 trying to catch monitor of object 1");
        synchronized (DeadLockEx.deadLock){
            System.out.println("TR-10 monitor of object 1 captured");
            System.out.println("TR-10 trying to catch monitor of object 2");
            synchronized (DeadLockEx.deadLock2){
                System.out.println("TR-10 monitor of object 2 captured");
            }
        }
    }
}

// блок синхронизации по 2 объекту, затем по первому
class Thread20 extends Thread{
    @Override
    public void run() {
        System.out.println("TR-20 trying to catch monitor of object 2");
        synchronized (DeadLockEx.deadLock2){
            System.out.println("TR-20 monitor of object 2 captured");
            System.out.println("TR-20 trying to catch monitor of object 1");
            synchronized (DeadLockEx.deadLock){
                System.out.println("TR-20 monitor of object 1 captured");
            }
        }
    }
}
