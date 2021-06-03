package io.exam;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;

public class ExamFile extends SimpleFileVisitor<Path> {
    public String str = null;
    private String poisk = null;
    private String fileName = null;
    private Path path = Paths.get(".");

    public static void main(String[] args) throws IOException {
        new ExamFile().go(args);
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(fileName, true))) {
            // byte[] bytes = file.toAbsolutePath().toString().getBytes();
            if (poisk.equals("mask")) {
                var linek = str.split("\\.");
                if (file.toAbsolutePath().getFileName().toString().contains(linek[1])) {
                    writer.println(file.toAbsolutePath().toString());
                    System.out.println(file.toAbsolutePath());
                }
            } else {
                if (file.toAbsolutePath().getFileName().toString().equals(str)) {
                    writer.println(file.toAbsolutePath().toString());
                    System.out.println(file.toAbsolutePath());
                }

            }
        }
       // System.out.println(file.toAbsolutePath().getFileName().toString().contains(str));
        return super.visitFile(file, attrs);
    }

    public void go(String[] line) throws IOException {

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
        for (String text
                :line) {
            System.out.println(text);
        }
        ExamFile vis = new ExamFile();
        vis.fileName = fileName;
        vis.str = str;
        vis.poisk = poisk;

        Files.walkFileTree(path, vis);
    }


}

