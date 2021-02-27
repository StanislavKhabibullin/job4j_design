package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {
    public static List<String> filter(String file) {
        try (BufferedReader in = new  BufferedReader(new FileReader(file))){
            var mas = in.lines().filter(s -> {
                List<String> masik = new ArrayList<>();
                boolean vibor = false;
                masik = Arrays.asList(s.split(String.valueOf(' ')));
                for (String filt:
                     masik) {
                    if (filt.equals("404")) {
                        vibor = true;
                    }
                }
                return vibor;
            }).collect(Collectors.toList());

            return  mas;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        for (int i = 0; i < log.size(); i++) {
            System.out.println(log.get(i));

        }
    }
}
