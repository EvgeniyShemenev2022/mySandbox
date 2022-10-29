package com.Shemenev;


import java.util.HashMap;
import java.util.Map;

/**
 * Напишите программу на Java, чтобы найти повторяющиеся символы в строке.
 */
public class RepeatingCharacters {

    public static void main(String[] args) {

        String line = "NASA spacecraft hits asteroid in Earth-protection test";
        isRepeatChar(line);
    }

    /**
     * Выводит на экран информацию о повторении букв в строке
     * по типу
     * n -> 2
     * o -> 3
     * p -> 2
     * S ->  is not repeat
     *
     * @param line
     */
    public static void isRepeatChar(String line) {

        Map<Character, Integer> map = new HashMap<>();

        String cleanedLine = line
                .replaceAll("[-+.^:,]", "")
                .replaceAll(" ", "");
        char[] charSequence = cleanedLine.toCharArray();

        for (char literal : charSequence) {
            if (!map.containsKey(literal)) {
                map.put(literal, 1);
            } else {
                map.put(literal, map.get(literal) + 1);
            }
        }
        for (Map.Entry repeated : map.entrySet()) {
            if ((Integer) repeated.getValue() > (Integer) 1) {  // Object -> Integer
                System.out.println(repeated.getKey() + " -> " + repeated.getValue());
            } else {
                System.out.println(repeated.getKey() + " -> " + " is not repeat");
            }
        }
    }
}
