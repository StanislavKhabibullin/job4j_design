package io;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class Analizy {
    Integer scramb = 0;
    public void unavailable(String source, String target) {
  //      Map<String, Integer> expect = new LinkedHashMap<>();
        List<String> result = new ArrayList<>();

        try (BufferedReader read = new BufferedReader(
                new FileReader(source)
        )){
            read.lines().forEach(s -> {
                String[] mas = s.split(" ");
                if (!mas[0].equals("")) {
                    if ((result.size() == 0) && (mas[0].equals("400") || mas[0].equals("500"))) {
                        result.add(mas[1]);
                        scramb = Integer.valueOf(mas[0]);

                    }
                    if ((mas[0].equals("200") || mas[0].equals("300")) && (scramb != 0)) {
                        result.add(mas[1]);
                        scramb = 0;
                    }
                    if ((mas[0].equals("400") || mas[0].equals("500")) && (scramb != 0)) {

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

        try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {

         /*   List<String> result = new ArrayList<>();
            Integer scramb = 0;
            for (Map.Entry <String, Integer> entry:
                 expect.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                if ((result.size() == 0) && (value == 400 || value == 500)) {
                    result.add(key);
                    scramb = value;
                    continue;
                }
                if ((value == 200 || value == 300) && (scramb != 0)) {
                    result.add(key);
                    scramb = 0;
                    continue;
                }
                if ((value == 400 || value == 500) && (scramb != 0)) {
                    continue;
                }
                if ((value == 400 || value == 500) && (scramb == 0)) {
                    result.add(key);
                    scramb = value;
                }
            }

          */

            for (int i = 0; i < result.size(); i++) {
                out.print(result.get(i));
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
