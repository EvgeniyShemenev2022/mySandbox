package com.Tasks;

/**
 * Напишите Java-программу, чтобы определить,
 * является ли строка или число палиндромом, или нет.
 */
public class Polindrom {
    public static void main(String[] args) {

        String word_1 = "yamayamay";
        int digit = 1156511;

        System.out.println(isPolindrom(word_1));
        System.out.println(isPolindrom(digit));
    }
    /**
     * Выясняет, является ли число/строка палиндромом
     * @param obj
     * @return boolean
     */
    public static boolean isPolindrom (Object obj){  // ввести данные можно и через scanner.nextLine
        String word = obj.toString();
        boolean answer = true;
        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - 1 - i)){
                answer = false;
                break;
            }
        }
        return answer;
    }
}
