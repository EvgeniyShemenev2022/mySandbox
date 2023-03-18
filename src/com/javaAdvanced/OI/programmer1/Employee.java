package com.javaAdvanced.OI.programmer1;

import java.io.Serializable;

// объект, класс которого не имплиментирует Serializable не может быть сериализован!
public class Employee implements Serializable {

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
