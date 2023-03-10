package com.javaAdvanced.OI;

import java.io.FileReader;
import java.io.IOException;

/**
 * FileReader
 * Простой пример чтения из файла (посимвольно) в блоке try/catch
 *
 */
public class FileReaderEx {

    public static void main(String[] args) throws IOException {

        FileReader reader = null;
        try {
            reader = new FileReader("IOtest.txt");
            int character;
            while ((character=reader.read()) != -1){
                System.out.print((char) character); // casting
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }
}
