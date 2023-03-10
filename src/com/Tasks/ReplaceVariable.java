package com.Tasks;

import java.util.Scanner;

/**
 * 1) Напишите программу на Java для того,
 * чтобы поменять местами значения, хранящиеся в двух переменных с помощью третьей переменной
 *
 * 2) Напишите программу на Java, чтобы поменять местами значения,
 * хранящиеся в двух переменных, без использования третьей переменной.
 *
 *
 */
public class ReplaceVariable {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        replacerWithoutTemp(a,b);
    }

    public static void replacer(int a, int b) {

        System.out.println(a + " & " + b);
        int temp = a;
        a = b;
        b = temp;
        System.out.println(a + " -> " + b);
    }

    public static void replacerWithoutTemp(int a, int b) {

        System.out.println(a + " & " + b);
        a ^= b;
        b ^= a;
        a ^= b;

//        a = a + b;
//        b = a - b;
//        a = a - b;

        System.out.println(a + " -> " + b);
    }
}
