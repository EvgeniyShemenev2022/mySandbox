package com.javaAdvanced.lambda;

import java.util.ArrayList;

public class StudentInfo {

    public static void main(String[] args) {

        Student student1 = new Student("Don", 'M', 17, 1, 8.3 );
        Student student2 = new Student("Karl", 'M', 18, 2, 7.2 );
        Student student3 = new Student("Duke", 'M', 17, 1, 9.5 );
        Student student4 = new Student("Mary", 'W', 19, 3, 5.2 );
        Student student5 = new Student("Samanta", 'W', 18, 2, 9.6 );

        ArrayList<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        // вызываем методы, наглядный пример неэффективного длинного кода
        StudentInfo info = new StudentInfo();
        info.printStudentOverGrade(students, 6.0);
        System.out.println("-----------------------------------------------");
        info.printStudentUnderAge(students, 18);
        System.out.println("-----------------------------------------------");
        info.printStudentMixCondition(students, 17, 9, 'W');

    }

    // фильтр по успеваемости
    void printStudentOverGrade(ArrayList<Student> list, double grade){
        for (Student student : list){
            if (student.avgGrade > grade){
                System.out.println(student);
            }
        }
    }

    // фильтр по возрасту
    void printStudentUnderAge(ArrayList<Student> list, int age){
        for (Student student : list){
            if (student.age > age){
                System.out.println(student);
            }
        }
    }

    // фильтр по разным параметрам
    void printStudentMixCondition(ArrayList<Student> list, int age, double grade, char sex){
        for (Student student : list){
            if (student.age > age && student.avgGrade < grade && student.sex == sex){
                System.out.println(student);
            }
        }
    }



}
