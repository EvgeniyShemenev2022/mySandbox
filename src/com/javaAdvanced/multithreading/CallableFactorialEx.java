package com.javaAdvanced.multithreading;

import java.util.concurrent.*;


/**
 *  интерфейс Callable<V>
 *      public V call() throws Exception {}
 *  отличается тем, что его метод .call() возвращает значение типа V и
 *  выбрасывает исключение (в тех случаях, когда необходимо);
 *
 * Метод .get() блокирует поток в котором был вызван, до завершения задания, чтобы суметь
 * вернуть результат в объект Future<Integer> future;
 * Метод .isDone() - позволяет получить статус о выполнении в определенный момент.
 * Метод .submit() аналогичен методу execute(), но возвращает результат метода в объект типа Future;
 */
public class CallableFactorialEx {

    static int factorialResult = 0;

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Factorial factorial = new Factorial(10);

        // .submit() аналогичен методу execute(), но возвращает результат метода в объект типа Future;
        Future<Integer> future = executorService.submit(factorial);
        try {
            System.out.println(future.isDone());
            // .get() блокирует поток в котором вызван, до завершения задания
            factorialResult = future.get();
            System.out.println(future.isDone());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println(e.getCause());
        }
        finally {
            executorService.shutdown();
        }
        System.out.println(factorialResult);
    }
}

// метод call() возвращает тип дженерика и выбрасывает исключение;
class Factorial implements Callable<Integer> {

    int f;

    public Factorial(int f) {
        this.f = f;
    }

    @Override
    public Integer call() throws Exception {

        if (f <= 0) {
            throw new Exception("You are enter wrong number!");
        }
        int result = 1;
        for (int i = 1; i <= f; i++) {
            result *= i;
        }
        return result;
    }
}
