package com.javaAdvanced.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Пример: 10 потоков должны вычислить сумму всех чисел от 1 до 1млрд.
 * На каждый поток приходится 1/10 часть вычислений;
 */
public class CallableBillionSumEx {

    private static long value = 1_000_000_000L;
    private static long sum = 0L;

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // создание нового пула с 10 потоками
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        // список результатов работы каждого потока
        List<Future<Long>> futureResults = new ArrayList<>();

        long valueDividedBy10 = value / 10;
        for (int i = 0; i < 10; i++) {
            long from = valueDividedBy10 * i + 1;
            long to = valueDividedBy10 * (i + 1);
            PartialSum task = new PartialSum(from, to);
            // присваиваем результат вычислений объекту futurePartSum и добавляем его в список
            Future<Long> futurePartSum = executorService.submit(task);
            futureResults.add(futurePartSum);
        }
        // складываем результаты вычислений
        for (Future<Long> result : futureResults) {
            sum += result.get();
        }
        executorService.shutdown();
        System.out.println("Total answer " + sum);
    }
}

// каждый поток будет считать часть общей суммы
class PartialSum implements Callable<Long> {

    long from;
    long to;
    long localSum;

    public PartialSum(long from, long to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public Long call() throws Exception {
        for (long i = from; i <= to; i++) {
            localSum += i;
        }
        System.out.println("Sum from " + from + " to " + to + " = " + localSum);
        return localSum;
    }
}



