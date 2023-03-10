package com.Tasks;

import java.io.*;

/**
 * Простой метод записи содержимого одного файла в другой
 */
public class InputOutput {
    public static void main(String[] args) throws Exception {

        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream("C:/Users/Evgeniy/Documents/java.txt");
            os = new FileOutputStream("C:/Users/Evgeniy/Documents/java2.txt");

            byte[] buffer = new byte[4096];
            int r = is.read(buffer);
            while (r != -1) {
                os.write(buffer, 0, r);
                r = is.read(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        is.close();
//        os.close();
    }

}
