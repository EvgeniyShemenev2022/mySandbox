package com.javaAdvanced.OI;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Stream (поток) для работы файлами - упорядоченная последовательность данных.
 *
 * Чтобы не затирать уже существующую информацию в файле, в конструкторе FileWriter
 * нужен второй параметр append: true
 */
public class FileWriterEx {

    public static void main(String[] args) throws IOException {

        String text = """
                Союз нерушимый республик свободных
                Сплотила навеки Великая Русь.
                Да здравствует созданный волей народов
                Единый, могучий Советский Союз!
                """;

        // чтобы добавить к уже существующему, нужен второй параметр append: true
        FileWriter writer = new FileWriter("IOtest.txt", true);

        // вариант №1 с циклом
        for (int i = 0; i < text.length(); i++) {
            writer.write(text.charAt(i));
        }

        // вариант №2 (внутри будет такая же посимвольная запись)
        writer.write(text);

        // по хорошему нужно закрывать в блоке finally
        writer.close();

        System.out.println("DONE!");
    }
}
