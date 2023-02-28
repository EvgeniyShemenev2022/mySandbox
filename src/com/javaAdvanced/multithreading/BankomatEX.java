package com.javaAdvanced.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * Вариант использования интерфейса Lock на примере очереди в банкомат;
 * Банкоматом может воспользоваться строго только один сотрудник в момент времени.
 * Остальные потоки ждут, пока текущий метод не откроет замок.
 */
public class BankomatEX {

    public static void main(String[] args) {

        Lock lock = new ReentrantLock();
        Employee employee1 = new Employee("Lenin", lock);
        Employee employee2 = new Employee("Stalin", lock);
        Employee employee3 = new Employee("Trotsky", lock);
        Employee employee4 = new Employee("Molotov", lock);
        Employee employee5 = new Employee("Andropov", lock);

    }
}

// пример использования LOCK в конструкторе класса;
class Employee extends Thread {

    private String name;
    private Lock lock;

    public Employee (String name, Lock lock){
        this.name = name;
        this.lock = lock;
        this.start(); // run thread at the creating time
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " стоит в очереди");
            lock.lock();
            System.out.println(name + " начинает пользоваться банкоматом");
            Thread.sleep(2000);
            System.out.println(name + " завершил(а) работу с банкоматом");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}