package com.javaAdvanced.OI;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Класс RandomAccessFile позволяет читать\записывать информацию из\в любое место файла.
 */
public class RandomAccessFileEx {

    public static void main(String[] args) {

        try (RandomAccessFile file = new RandomAccessFile("IOtest3.txt", "rw")) {

            // The byte is returned as an integer in the range 0 to 255
            int a = file.read();
            System.out.println((char) a);  // читает первый символ и передвигает каретку

            a = file.read();
            System.out.println((char) a);  // читает второй символ и передвигает каретку

            String s = file.readLine(); // читает строку учитывая текущее положение каретки
            System.out.println(s);

            file.seek(100);  // перемещает каретку на указанную позицию
            String s2 = file.readLine();
            System.out.println(s2);

            long position = file.getFilePointer(); // текущее положение каретки
            System.out.println(position);

            file.seek(27);
            file.writeBytes("\nHALLO!\n"); // ПЕРЕзаписываем в конкретное место

            file.seek(file.length());
            file.writeBytes("\n\t\t\t\tRevolution Song"); // пишем в конец файла

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
