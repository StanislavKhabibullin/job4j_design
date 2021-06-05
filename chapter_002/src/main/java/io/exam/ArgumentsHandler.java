package io.exam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class ArgumentsHandler {
    public String str = null;
    private String poisk = null;
    private String fileName = null;
    private Path path = Paths.get(".");

    public String getStr() {
        return str;
    }

    public String getPoisk() {
        return poisk;
    }

    public String getFileName() {
        return fileName;
    }

    public Path getPath() {
        return path;
    }

    public void getArguments(String[] line) throws IOException {
        Arrays.stream(line).forEach(
                s -> {
                    String[] mas = s.split("=");
                    switch (mas[0]) {
                        case "-d":
                            path = Paths.get(mas[1]);
                            break;
                        case "-n":
                            str = mas[1];
                            break;
                        case "-t":
                            poisk = mas[1];
                            break;
                        case "-o":
                            fileName = mas[1];
                            break;
                        default:
                            System.out.println("Error input attributes");
                    }
                }
        );
        if (poisk.equals("mask")) {
            var mik = str.split("\\.");
            str = "." + mik[1];
        }
    }

}
