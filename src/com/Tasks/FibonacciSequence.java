package com.Tasks;

import java.util.Scanner;


/**
 * Написать программу на Java для вычисления серии чисел Фибоначчи.
 * Последовательность чисел Фибоначчи:
 * 0 1 1 2 3 5 8 13  и т.д.
 */
public class FibonacciSequence {
    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        long inputDigit = scanner.nextInt();

        fibonacciCompute(inputDigit);
    }

    /**
     * выводит на экран все числа Фибона́ччи из заданного диапазона
     * @param inputDigit
     * @throws InterruptedException
     */
    public static void fibonacciCompute(long inputDigit) throws InterruptedException {

        long a = -1;
        long b = 1;
        long fibNumb = 0;

        for (int i = 0; i <= inputDigit; i++) {
            fibNumb = a + b;
            a = b;
            b = fibNumb;

            Thread.sleep(500);
            System.out.println(i + "  " + fibNumb + " -> ");
        }
    }
}
