package io;

import java.io.*;
import java.util.*;


public class Analizy {
    Integer scramb = 0;
    public void unavailable(String source, String target) {
        List<String> result = new ArrayList<>();

        try (BufferedReader read = new BufferedReader(
                new FileReader(source)
        )){
            read.lines().forEach(s -> {
                String[] mas = s.split(" ");
                if (!mas[0].equals("")) {
                    if ((mas[0].equals("200") || mas[0].equals("300")) && (scramb != 0)) {
                        result.add(mas[1]);
                        scramb = 0;
                    }
                    if ((mas[0].equals("400") || mas[0].equals("500")) && (scramb == 0)) {
                        result.add(mas[1]);
                        scramb = Integer.valueOf(mas[0]);
                    }

                }
            });

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        writeFile(target, result);
    }

    public static void writeFile(String target, List<String> res) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            for (int i = 0; i < res.size(); i++) {
                out.print(res.get(i));
                if (i % 2 == 1) {
                    out.println();
                } else {
                    out.print(';');
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv")))  {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Analizy test = new Analizy();
        test.unavailable("source.csv", "target.csv");
    }
}
