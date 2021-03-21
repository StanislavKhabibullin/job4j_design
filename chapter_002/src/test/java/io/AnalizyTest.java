package io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AnalizyTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenUseTemporaryFolder() throws IOException {
        File source = folder.newFile("source.csv");
        File target = folder.newFile("target.csv");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("300 10:10:10");
            out.println("400 10:12:10");
            out.println("500 10:14:14");
            out.println("200 10:20:10");
            out.println("300 11:10:10");
        }
        Analizy test = new Analizy();
        test.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(target))) {
            reader.lines().forEach(line -> rsl.append(line));
        }
        assertThat(rsl.toString(), is("10:12:10;10:20:10"));
    }

    @Test
    public void whenPairOneSwitchOut() {
        String path1 = "test_Analizy1.csv";
        String path2 = "test_Analizy2.csv";
        Analizy test1 = new Analizy();
        test1.unavailable(path1, path2);
        String result = "";
        try (BufferedReader reader = new BufferedReader(
                new FileReader(path2)
        )) {
            var expect = reader.lines().collect(Collectors.toList());
            for (String val
                    : expect) {
                result = result + val;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(result, is("10:58:01;10:59:01"));
    }

}