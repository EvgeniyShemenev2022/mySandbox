package com.javaAdvanced.stream.foreach;

import java.util.Arrays;


public class ForeachExample {

    public static void main(String[] args) {

        int[] array = {1, 5, 15, 54, 34};

        // пример использования method-reference
        Arrays.stream(array).forEach(Utils::method);

    }
}

// реализуем свой класс и метод
class Utils {
    public static void method(int a) {
        a = a + 5;
        System.out.println("Output -> " + a);
    }
}