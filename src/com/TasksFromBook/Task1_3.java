package com.TasksFromBook;

/**
 * Инвертирование букв и слов.
 * Написать программу, которая инвертирует буквы каждого слова, и программу,
 * которая инвертирует буквы каждого слова и сами слова.
 */
public class Task1_3 {

    public static String line = "Без труда не выловишь и рыбку из пруда.";

    public static void main(String[] args) {

        System.out.println(reverse(line));
        System.out.println(reverse2(line));

    }

    // используя .reverse() - зеркальная инверсия
    public static String reverse(String str) {

        return new StringBuilder(str).reverse().toString();
    }


    //  используя StringBuilder
    public static String reverse2(String str) {

        StringBuilder reversedString = new StringBuilder();

        String[] words = str.split(" ");
        // идем по словам
        for (String word : words) {
            StringBuilder reversWords = new StringBuilder();

            // идем по буквам в каждом слове
            for (int i = word.length() - 1; i >= 0; i--) {
                reversWords.append(word.charAt(i));
            }
            reversedString.append(reversWords).append(" ");
        }
        return reversedString.toString();
    }
}
