package io.duplicates;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    public List<FileProperty> mas = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
            throws IOException {
        File file1 = new File(String.valueOf(file));

        for (FileProperty masik
                :mas) {
            if ((masik.getSize() == file1.length())
                    && (masik.getName().equals(file.getFileName().toString()))) {
                System.out.println("Dubl:  Size - " + masik.getSize()
                        + " Name - " + masik.getName());
            }
        }
        mas.add(new FileProperty(file1.length(), file.getFileName().toString()));
        return super.visitFile(file, attrs);
    }

    public static void main(String[] args) throws IOException {
        DuplicatesVisitor visitor = new DuplicatesVisitor();
        Path start = Paths.get(".");
        Files.walkFileTree(start, visitor);

    }
}
