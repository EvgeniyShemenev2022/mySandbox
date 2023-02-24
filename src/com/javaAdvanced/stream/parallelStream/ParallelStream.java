package com.javaAdvanced.stream.parallelStream;

import java.util.List;

/**
 * Важный момент!
 * Параллельные потоки имеет смысл использовать только
 * при большом количестве вводных данных;
 *
 * !!! параллельный поток при делении элементов выдает НЕВЕРНЫЙ результат
 * если важна очередность операций (вычитание, деление);
 */
public class ParallelStream {

    public static void main(String[] args) {

        List<Double> list = List.of(10.0, 5.0, 15.5, 0.75);

        // простой поток
        double sumOfElements = list.stream().reduce((a, b) -> a + b).get();
        System.out.println(sumOfElements);  // Output: 31.25

        // параллельный поток
        double sumOfElements2 = list.parallelStream().reduce(Double::sum).get();
        System.out.println(sumOfElements2);  // Output: 31.25


        // простой поток при делении элементов выдает ПРАВИЛЬНЫЙ результат
        double result = list.stream().reduce((a, b) -> a / b).get();
        System.out.println(result);  // Output: 0.17204301075268816


        // параллельный поток при делении элементов выдает НЕВЕРНЫЙ результат
        // если важна очередность операций (вычитание, деление)
        double result2 = list.parallelStream().reduce((a, b) -> a / b).get();
        System.out.println(result2);  // Output: 0.0967741935483871
    }
}
