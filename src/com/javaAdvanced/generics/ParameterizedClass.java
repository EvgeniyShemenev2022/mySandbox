package com.javaAdvanced.generics;


public class ParameterizedClass {

    public static void main(String[] args) {

        Info<String> greeting = new Info<>("WELCOME TO RUSSIA");
        System.out.println(greeting);
        // Output: ==> WELCOME TO RUSSIA <==

    }
}

/**
 * Подобные классы могут понадобиться, если, например, необходимо несколько одинаковых по строению классов,
 * но с разными типами полей и с разными return type-ами методов.
 * @param <T> type placeholder
 */
// usually T- means Type; K- keys; E-element; V- value;
class Info<T> {
    private T value; // cannot be static

    public Info(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "==> " +  value + " <==";
    }
}
