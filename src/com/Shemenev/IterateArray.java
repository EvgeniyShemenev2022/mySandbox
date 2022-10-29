package com.Shemenev;

import java.util.ArrayList;
import java.util.List;


/**
 * Итерация списков различными способами
 */
public class IterateArray {
    public static void main(String[] args) {

        List<String> array = new ArrayList<>();
        array.add("Mickle");
        array.add("Roudy");
        array.add("Beavis");
        array.add("Buthead");
        array.add("Pinokkio");

        iterateFor(array);
        iterateWhile(array);
        iterateForEach(array);
    }

    public static void iterateFor (List<String> array) {

        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i) + "-----");
        }
    }

    public static void iterateWhile (List<String> array) {   // или с помощью Итратора
                                                             // Iterator iterator = array.iterator();
        int count = 0;
        while (count < array.size()){
            System.out.println(array.get(count) + "++++++");
            count++;
        }
    }

    public static void iterateForEach (List<String> array) {

        array.forEach(System.out::println);
    }
}
