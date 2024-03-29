package io;

import java.io.*;
import java.util.*;


public class Analizy {

    public void unavailable(String source, String target) {
        Integer scramb = 0;
        List<String> result = new ArrayList<>();

        try (BufferedReader read = new BufferedReader(
                new FileReader(source)
        )) {
            var lin = read.readLine();
            while (lin != null) {

                    String[] mas = lin.split(" ");
                    String begin = mas[0];

                    if (!begin.equals("")) {
                        String end = mas[1];
                        if ((begin.equals("200") || begin.equals("300")) && (scramb != 0)) {
                            result.add(end);
                            scramb = 0;
                        }
                        if ((begin.equals("400") || begin.equals("500")) && (scramb == 0)) {
                            result.add(end);
                            scramb = Integer.valueOf(begin);
                        }

                    }
                lin = read.readLine();
            }

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
