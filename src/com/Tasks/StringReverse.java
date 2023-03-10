package com.Tasks;

import java.util.Arrays;

/**
 * Напишите программу на Java для переворачивания строки,
 * изменив расположение символов в строке задом наперёд без
 * использования встроенных в String функций.
 */
public class StringReverse {

    static String line = "Apocaliptica and me";

    public static void main(String[] args) {

        reverseWithStrBuilder(line);
        reverseWithCharArray(line);
        printReversChars(line);
        printWithScanner(line);
    }

    public static void reverseWithStrBuilder(String line) {
        StringBuilder stB = new StringBuilder();
        stB.append(line);
        stB.reverse();
        System.out.println("1 " + stB);
    }

    public static void reverseWithCharArray(String line) {

        char[] chars = line.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char x = chars[chars.length - i - 1];    // from end to x
            chars[chars.length - i - 1] = chars[i];  // from head to end
            chars[i] = x;                            // from x to head
        }
        System.out.println(Arrays.toString(chars));
    }

    public static void printReversChars(String line) {

        char[] chars = line.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            System.out.print(chars[i]);
        }
    }

    public static void printWithScanner(String line) {

//        Scanner scanner = new Scanner(line);         // если нужно ввести строку из консоли
        String[] literal = line.split("");
        for (int i = literal.length - 1; i >= 0; i--) {
            System.out.print(literal[i]);
        }
    }
}
