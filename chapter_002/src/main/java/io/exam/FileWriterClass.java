package io.exam;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class FileWriterClass {
    public void writeInFile(List<Path> mas, String name) throws IOException {
        if (!mas.equals(null)) {
            try (FileWriter fw = new FileWriter(name, true)) {
                for (Path stroka :
                        mas) {
                    fw.write(stroka + System.lineSeparator());
                }
            }
        } else {
            System.out.println("Нулевой массив данных");
        }
    }
}
