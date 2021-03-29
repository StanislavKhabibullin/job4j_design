package io;

import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Search {
    public List<Path> search(Path root, Predicate<Path> condition) {
        Path start = root;
        SearchFiles searcher = new SearchFiles(condition);
        try {
            Files.walkFileTree(start, searcher);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return searcher.getPaths;
    }



    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            throw new IllegalArgumentException("Root folder is null. file extension is null.");
        }
        if (args.length >= 3) {
            throw new IllegalArgumentException("To much arguments");
        }
        if (args.length == 1) {
            throw new IllegalArgumentException("Need one more argument");
        }
        Path start = Paths.get(args[0]);
        Search ser = new Search();
        ser.search(start, p -> p.toFile().getName().endsWith(args[1])).forEach(System.out::println);
    }
}
