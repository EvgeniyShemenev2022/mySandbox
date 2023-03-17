package com.javaAdvanced.OI.programmer1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SerializationEx1 {

    public static void main(String[] args) {

        List<String> employees = new ArrayList<>(Arrays.asList("Timur", "Neo", "Shrek", "Napoleon"));

        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("employees.bin"))){
            outputStream.writeObject(employees);
            System.out.println("Done");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


