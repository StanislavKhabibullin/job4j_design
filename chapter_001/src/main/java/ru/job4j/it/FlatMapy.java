package ru.job4j.it;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapy {
    public static void main(String[] args) {
        List<List<Integer>> data = List.of(
                List.of(1, 2, 3),
                List.of(4, 5, 6),
                List.of(7, 8, 9)
        );
        var flat = data.stream().flatMap(rsl ->
            rsl.stream()
        ).collect(Collectors.toList());
        System.out.println(flat);
    }
}
