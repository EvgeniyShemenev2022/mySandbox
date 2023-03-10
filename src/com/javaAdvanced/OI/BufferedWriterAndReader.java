package com.javaAdvanced.OI;

import java.io.*;

/**
 * BufferedWriter & BufferedReader являются классами-обертками для
 * FileWriter & FileReader; Позволяет начать воспроизведение потока даже
 * в момент неполной загрузки;
 * <p>
 * Использование буферизации позволяет достичь большей производительности;
 * <p>
 * В этом примере происходит чтение из одного файла и одновременная запись
 * всего содержимого в другой.
 * <p>
 * Используется для читабельных файлов. Для прочих файлов есть классы
 * FileInputStream & FileOutputStream;
 */
public class BufferedWriterAndReader {

    public static void main(String[] args) {

        // блок try with resources позволяет не закрывать буферы вручную;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("IOtest2.txt"));
             BufferedReader reader = new BufferedReader(new FileReader("IOtest.txt"))) {

            // ex #1
            int i;
            while ((i = reader.read()) != -1) {
                writer.write(i);
            }

            // ex #2; построчное чтение/запись
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.write('\n'); // перевод каретки
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
