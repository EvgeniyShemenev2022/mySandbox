package com.javaAdvanced.generics;


import java.util.ArrayList;
import java.util.List;

public class WildCard {

    public static void main(String[] args) {

        // <?> - Super Type
        List<?> wildcardList = new ArrayList<Integer>();

        ArrayList<Double> anyDoubles = new ArrayList<>();
        anyDoubles.add(3.14);
        anyDoubles.add(3.15);
        anyDoubles.add(3.16);
        showListInfo(anyDoubles);
        // Output: These list includes are: [3.14, 3.15, 3.16]

        System.out.println(sum(anyDoubles));
        // Output: 9.45
    }

    // будет работать со списками любых типов
    static void showListInfo(List<?> list) {
        System.out.println("These list includes are: " + list);
    }

    // работает с любым списком, который унаследован от класса Number
    public static double sum(ArrayList<? extends Number> list) {

        double sum = 0d;
        for (Number el : list) {
            sum += el.doubleValue();
        }
        return sum;

    }

}
