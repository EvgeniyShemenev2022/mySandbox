package com.javaAdvanced.generics;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParameterizedMethod {

    public static void main(String[] args) {

        ArrayList<Integer> digits = new ArrayList<>();
        digits.add(1);
        digits.add(2);
        digits.add(3);
        int firstEl = GenericsMethod.getFirstElement(digits);
        System.out.println(firstEl);
    }

}

/**
 *  необязательно статический
 *  <T> T указывает компилятору, что это параметризованный тип
 */
class GenericsMethod {
    public static <T> T getFirstElement(ArrayList<T> list){

        return list.get(0);
    }
}