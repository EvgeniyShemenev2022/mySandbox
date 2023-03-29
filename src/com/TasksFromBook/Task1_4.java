package com.TasksFromBook;

/**
 * Проверка, содержит ли строковое значение только цифры.
 * Написать программу, которая проверяет, что заданная строка содержит только цифры.
 * <p>
 * решения на основе функционального стиля Java 8 и регулярных выражений обычно являются медленными,
 * поэтому если требуется скорость, лучше опираться на первое решение с использованием метода
 * Character.isDigit().
 */
public class Task1_4 {

    private static String str = "4576549948";

    public static void main(String[] args) {

        System.out.println(isOnlyNumbers(str));
        System.out.println(isOnlyNumbers2(str));
        System.out.println(isOnlyNumbers3(str));

    }

    public static boolean isOnlyNumbers(String str) {

        for (char ch : str.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isOnlyNumbers2(String str) {

        // вместо знака отрицания можно использовать метод .noneMatch()
        return str.chars()
                .allMatch(Character::isDigit);
    }

    public static boolean isOnlyNumbers3(String str) {

        return str.matches("[0-9]+");
    }
}
