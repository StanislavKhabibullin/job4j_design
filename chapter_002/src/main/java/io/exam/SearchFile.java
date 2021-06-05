package io.exam;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFile  extends SimpleFileVisitor<Path> {
    public String maska_poiska = "";
    public ArrayList<Path> mas = new ArrayList<>();
    

    public SearchFile(String maska_poiska) {
        this.maska_poiska = maska_poiska;
    }

    

    public SearchFile() {
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        if (file.toAbsolutePath().toString().contains(maska_poiska)) {
            System.out.println(file.toAbsolutePath());
            mas.add(file.toAbsolutePath());
        }
        return super.visitFile(file, attrs);
    }

    public List<Path> search(String path, String mask) throws IOException {
        SearchFile poisk = new SearchFile(mask);
        Files.walkFileTree(Paths.get(path), poisk);
        return poisk.mas;
    }

    public static void main(String[] args) throws IOException {
        SearchFile searchFile = new SearchFile();
        var iting =  searchFile.search(".", "pom.xml");
        FileWriterClass fileWriterClass = new FileWriterClass();
        fileWriterClass.writeInFile(iting, "testik_rez.txt");
    }
}
