package com.javaAdvanced.lambda;

// самостоятельная организация работы функционального интерфейса
// по принципу интерфейса Predicate<T>
public class Functional {

    static void def(I i) {
        System.out.println(i.abc("Something else."));
    }

    public static void main(String[] args) {

        def((String str) -> {
            return str.length();
        });
        //Output: 15
    }
}

interface I {
    int abc(String s);
}