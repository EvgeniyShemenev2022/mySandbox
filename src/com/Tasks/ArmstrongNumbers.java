package com.Tasks;

import java.util.Scanner;

/**
 * Напишите Java-программу для проверки является ли введенное число - числом Армстронга.
 */
public class ArmstrongNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number OR  press q to exit");

        long input;
        while (scanner.hasNext()) {
            String q = scanner.nextLine();
            if (q.equals("q")) {
                break;
            } else
                input = Long.parseLong(q);
            isThisArmstrongNumber(input);
        }
    }

    /**
     * Выводит сообщение о том, является ли введенное число
     * числом Армстронга
     * пример: 153 = 1*1*1 + 5*5*5 + 3*3*3
     *
     * @param input
     */
    public static void isThisArmstrongNumber(long input) {

        // number -> digits array
        int[] inputAsArray = Long.toString(input).chars().map(x -> x - '0').toArray();
        long summ = 0;

        for (int j : inputAsArray) {
            summ += Math.pow(j, inputAsArray.length);
        }
        if (input == summ) {
            System.out.println(input + "  is the Armstrong number");
        } else {
            System.out.println((input + "  is NOT the Armstrong number"));
        }
    }
}
