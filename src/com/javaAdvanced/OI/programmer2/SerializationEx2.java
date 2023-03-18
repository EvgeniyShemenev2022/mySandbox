package com.javaAdvanced.OI.programmer2;

import com.javaAdvanced.OI.programmer1.Employee;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Производится чтение объекта из бинарного файла с помощью
 * класса ObjectInputStream;
 * <p>
 * Объект должен implements Serializable!!!
 * <p>
 * Все другие объекты, являющиеся параметрами записываемого объекта так же
 * должны быть Serializable!!!
 */
public class SerializationEx2 {

    public static void main(String[] args) {

        Employee employee;

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("employees.bin"))) {
            // casting cause .readObject() returns object
            employee = (Employee) inputStream.readObject();
            System.out.println(employee);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


