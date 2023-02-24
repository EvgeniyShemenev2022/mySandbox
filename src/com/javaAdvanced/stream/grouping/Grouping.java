package com.javaAdvanced.stream.grouping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Мощный инструмент для группировки объектов по параметрам или заданным условиям;
 * .groupingBy()
 * .partitioningBy()
 *
 * это терминальные методы
 */
public class Grouping {

    public static void main(String[] args) {

        Student student1 = new Student("Don", 'M', 17, 1, 8.3 );
        Student student2 = new Student("Karl", 'M', 18, 2, 7.2 );
        Student student3 = new Student("Duke", 'M', 17, 1, 9.5 );
        Student student4 = new Student("Mary", 'W', 19, 3, 5.2 );
        Student student5 = new Student("Samanta", 'W', 18, 2, 9.6);

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);


        // .groupingBy() согласно курсу
        Map<Integer,List<Student>> groupingList = students.stream()
                .map(student -> {student.setName(student.getName().toUpperCase());
                return student;})
                .collect(Collectors.groupingBy(Student::getCourse));

        // выводим построчно 1: [Student{name='DON', sex=M, age=17,  и т.д.
        for (Map.Entry<Integer,List<Student>> entry : groupingList.entrySet() ){
            System.out.println(entry.getKey() + ": " + entry.getValue().toString());
        }

        System.out.println("--------------------------------------------------------");

        // .partitioningBy()  условие boolean
        Map<Boolean, List<Student>> map = students.stream()
                .collect(Collectors.partitioningBy(st -> st.getAvgGrade() > 7));
        for (Map.Entry<Boolean,List<Student>> entry : map.entrySet() ){
            System.out.println(entry.getKey() + ": " + entry.getValue().toString());
        }
        // Output:
        // false: [Student{name='MARY', sex=W, age=19, course=3 ......
        // true: [Student{name='DON', sex=M, age=17, course=1, ......

    }
}
