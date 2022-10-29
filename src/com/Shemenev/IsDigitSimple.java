package com.Shemenev;

import java.util.Scanner;

/**
 * Напишите программу на Java, чтобы узнать, является ли число простым или нет.
 * <p>
 * Это натуральное число больше 1, у которого есть всего два делителя: единица и само число.
 */
public class IsDigitSimple {
    public static void main(String[] args) {

        int a = -1;
        int b = 133;
        int c = 9;

        System.out.println(isSimple(a));
        System.out.println(isSimple(b));
        System.out.println(isSimple(c));

        // вариант со вводом из консоли
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        int y = scanner.nextInt();
        scanner.close();

        System.out.println(isSimple(x));
        System.out.println(isSimple(y));
    }

    /**
     * Проверяет, является ли число простым
     *
     * @param digit
     * @return boolean
     */
    public static boolean isSimple(int digit) {

        boolean areDividers = false;
        if (digit > 1) {
            for (int i = 2; i < digit; i++) {
               areDividers =  digit % i == 0;
                if (areDividers == true)  break;
            }
        } else {
            System.out.println(" введенное число <= 1 ");
        }
        return !areDividers;
    }
}
