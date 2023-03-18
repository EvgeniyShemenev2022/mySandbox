package com.javaAdvanced.OI.programmer1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Производится запись объекта в бинарный файл с помощью
 * класса ObjectOutputStream;
 * <p>
 * Объект должен implements Serializable!!!
 */
public class SerializationEx2 {

    public static void main(String[] args) {

        Employee employee1 = new Employee("Olga", "IT", 28, 5000);

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("employees.bin"))) {

            outputStream.writeObject(employee1);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
