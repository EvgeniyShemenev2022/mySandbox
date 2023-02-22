package com.javaAdvanced.lambda;


import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * Рассмотрена работа с функ.интерфейсом Predicate<T>
 *     методы  .and(); .or(); .negate();
 * А так же функ.интерфейсом Consumer<T>
 */
public class RemoveIf {

    public static void main(String[] args) {

        ArrayList<String> words = new ArrayList<>();
        words.add("hallo");
        words.add("buy");
        words.add("welcome");
        words.add("see you");
        words.add("hi");

        // пример использования метода .forEach()
        words.forEach(s -> {
            s = s + "+";
            System.out.print(s);
        });


        // predicate возвращает значение boolean
        words.removeIf(s -> s.length() > 4);
        System.out.println(words); // Output: [buy, hi]

        // аналогично предыдущему
        Predicate<String> pr = s -> s.length() > 2;
        words.removeIf(pr);
        words.forEach(System.out::println);

        // условные примеры методов
        Predicate<String> pr2 = s -> !s.equals("hallo");
        pr.negate(); //  результат обратного условия
        pr.and(pr2); //  результат двух условий
        pr.or(pr2); //  результат одного ИЗ удовлетворенных условий








    }

}
