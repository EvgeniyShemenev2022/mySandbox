package com.javaAdvanced.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/**
 * Lambda Expressions:
 *
 * method(() -> 5)
 * method( x -> x.length() )
 * method( String x -> x.length() )
 * method( (x, y) -> x.length() )
 * method( (String x, String y) -> x.length() )
 * ! если используются {} то необходим  return
 */
public class StudentInfoWithLambda {

    // метод, который принимает объект типа функц.интерфейса
    void testStudents (ArrayList<Student> students, StudentCheck studentCheck ){
        for (Student student : students) {
            if (studentCheck.check(student)){
                System.out.println(student);
            }
        }
    }

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

        // используем синтаксис lambda выражения (разные варианты)
        StudentInfoWithLambda info = new StudentInfoWithLambda();

        // одинаковый функционал
        info.testStudents(students, s -> s.avgGrade > 8.5 );
        info.testStudents(students, (Student s) -> {return s.avgGrade > 8.2;} );

        // если выражений больше 1, то короткий вариант записи невозможен
        info.testStudents(students, student -> {
            System.out.println("hallo");
            return student.avgGrade > 8;
        });
        System.out.println("-----------------------------------");

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {

                return s1.age - s2.age;
            }
        });
        System.out.println(students);
        //Output: выведет студентов в порядке возраста

        System.out.println("-----------------------------------");

        // аналогичный вариант
        Collections.sort(students, (st1, st2) -> st1.age - st2.age);
        System.out.println(students);

    }

}
// functional interface (only 1 method! )
interface StudentCheck{
    boolean check(Student student);
}