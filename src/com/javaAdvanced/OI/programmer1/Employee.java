package com.javaAdvanced.OI.programmer1;

import java.io.Serializable;

/**
 * Объект, класс которого не имплиментирует Serializable не может быть сериализован!
 * <p>
 * Настоятельно рекомендуется явным образом объявлять serialVersionUID у объекта, т.к.
 * внутренний механизм компилятора очень чувствителен к изменению содержания класса.
 */
public class Employee implements Serializable {

    static final long serialVersionUID = 1;
    String name;
    String department;
    int age;
    double salary;

    public Employee(String name, String department, int age, double salary) {
        this.name = name;
        this.department = department;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
