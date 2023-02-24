package com.javaAdvanced.stream.min_max;

import com.javaAdvanced.stream.grouping.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * методы min() & max() требуют в параметрах компаратор;
 *
 * это терминальные методы, возвращают Optional
 */
public class MinMax {

    public static void main(String[] args) {

        com.javaAdvanced.stream.grouping.Student student1 = new com.javaAdvanced.stream.grouping.Student("Don", 'M', 17, 1, 8.3);
        com.javaAdvanced.stream.grouping.Student student2 = new com.javaAdvanced.stream.grouping.Student("Karl", 'M', 18, 2, 7.2);
        com.javaAdvanced.stream.grouping.Student student3 = new com.javaAdvanced.stream.grouping.Student("Duke", 'M', 17, 1, 9.5);
        com.javaAdvanced.stream.grouping.Student student4 = new com.javaAdvanced.stream.grouping.Student("Mary", 'W', 19, 3, 5.2);
        com.javaAdvanced.stream.grouping.Student student5 = new com.javaAdvanced.stream.grouping.Student("Samanta", 'W', 18, 2, 9.6);

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        // две одинаковые записи, с методами min() & max()
        Student st1 = students.stream().min(Comparator.comparingInt(Student::getAge)).get();
        System.out.println(st1);
        Student st2 = students.stream().max((x,y) -> x.getAge() - y.getAge()).get();
        System.out.println(st2);

    }
}
