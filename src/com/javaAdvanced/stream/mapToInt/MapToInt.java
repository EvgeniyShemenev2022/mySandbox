package com.javaAdvanced.stream.mapToInt;

import java.util.ArrayList;
import java.util.List;

/**
 * метод .mapToInt() позволяет получить поток int/double/long;
 * метод .boxed() оборачивает примитивы;
 * .sum() суммирует результат;
 * методы: .average(), .min(), .max()  возвращают Optional, поэтому если проверка .ifPresent()
 * не нужна, то необходим метод .getAsDouble() / .getAsInt()
 *
 */
public class MapToInt {

    public static void main(String[] args) {

        Student student1 = new Student("Don", 'M', 17, 1, 8.3);
        Student student2 = new Student("Karl", 'M', 18, 2, 7.2);
        Student student3 = new Student("Duke", 'M', 17, 1, 9.5);
        Student student4 = new Student("Mary", 'W', 19, 3, 5.2);
        Student student5 = new Student("Samanta", 'W', 18, 2, 9.6);

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);


        // !! метод .boxed() оборачивает примитивы !!
        List<Integer> stAges = students.stream()
                .mapToInt(Student::getAge)
                .sorted()
                .boxed().toList();
        System.out.println(stAges);  // Output: [17, 17, 18, 18, 19]


        // .sum() суммирует результат
        int sumOfAges = students.stream().mapToInt(Student::getAge).sum();
        System.out.println(sumOfAges);  // Output: 89


        // .average() усредняет результат
        double average = students.stream()
                .mapToInt(Student::getCourse)
                .average()
                .getAsDouble(); // Optional
        System.out.println(average);  // Output: 1.8


        // метод .min()
        int min = students.stream()
                .mapToInt(Student::getAge)
                .min()
                .getAsInt(); // Optional
        System.out.println(min);  // Output: 17


        // метод .max()
        int max = students.stream()
                .mapToInt(Student::getAge)
                .max()
                .getAsInt(); // Optional
        System.out.println(max);  // Output: 19

    }

}
