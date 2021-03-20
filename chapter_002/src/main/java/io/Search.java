package io;

import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Search {
    public static List<Path> search(Path root, Predicate<Path> condition) {
        Path start = root;
        SearchFiles searcher = new SearchFiles(condition);
        try {
            Files.walkFileTree(start, searcher);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return searcher.getPaths.stream().filter(condition).collect(Collectors.toList());
    }



    public static void main(String[] args) throws IOException {
        Path start = Paths.get(".");
        search(start, p -> p.toFile().getName().endsWith("html")).forEach(System.out::println);
    }
}
