package io.exam;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFile  extends SimpleFileVisitor<Path> {
    public String maskaPoiska = "";
    public String meaning = "";
    public ArrayList<Path> mas = new ArrayList<>();

    

    public SearchFile(String maskaPoiska, String meaning) {
        this.meaning = meaning;
        this.maskaPoiska = maskaPoiska;
    }

    

    public SearchFile() {
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        PredicateSearch predicateSearch = new PredicateSearch();
        if (predicateSearch.poisk(file, maskaPoiska, meaning) != null) {
            System.out.println(file.toAbsolutePath());
            mas.add(file.toAbsolutePath());
        }
        return super.visitFile(file, attrs);
    }

    public List<Path> search(String path, String mask, String meaning) throws IOException {
        SearchFile poisk = new SearchFile(mask, meaning);
        Files.walkFileTree(Paths.get(path), poisk);
        return poisk.mas;
    }

    public static void main(String[] args) throws IOException {


        SearchFile searchFile = new SearchFile();
        var iting =  searchFile.search(".", "RegEx", "pom.xml");
        FileWriterClass fileWriterClass = new FileWriterClass();
        fileWriterClass.writeInFile(iting, "testik_rez.txt");
    }
}
