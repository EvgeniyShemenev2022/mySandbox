package com.javaAdvanced.stream.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Метод Filter использует Predicate<T>
 *     return boolean;
 * Это промежуточный метод.
 */
public class Student {

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


        // применяем фильтр с двумя условиями, затем присваиваем изменения листу
        students = students.stream().
                filter(st -> st.age > 17 && st.sex == 'M').collect(Collectors.toList());
        students.forEach(System.out::println);

    }

     String name;
     char sex;
     int age;
     int course;
     double avgGrade;

    public Student(String name, char sex, int age, int course, double avgGrade) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.course = course;
        this.avgGrade = avgGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", course=" + course +
                ", avgGrade=" + avgGrade +
                '}';
    }
}
