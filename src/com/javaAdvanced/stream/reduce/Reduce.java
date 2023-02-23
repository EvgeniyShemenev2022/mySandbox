package com.javaAdvanced.stream.reduce;

import java.util.List;
import java.util.Optional;


/**
 * метод .reduce() возвращает Optional<>
 */
public class Reduce {

    public static void main(String[] args) {

        // пример работы метода .reduce()
        List<Integer> list = List.of(1, 2, 3, 5, 6, 7, 79, 64, 15, 48);

        int a = list.stream().reduce((accumulator, element) -> accumulator * element).get();
        System.out.println(a); // 1*2 = 2; 2*3 = 6; 6*5= 30; и т.д.

        // 2 задает стартовое значение переменной accumulator; может быть любым числом;
        int b = list.stream().reduce(2, (accumulator, element) -> accumulator * element);
        System.out.println(b);


        // просто для примера работы интерфейса Optional<> пустой список
        List<Integer> list2 = List.of();

        Optional<Integer> result = list2.stream().reduce( (accumulator, element) -> accumulator * element);
        if (result.isPresent()){
            System.out.println(result);
        }else
            System.out.println("not present");

    }


}
