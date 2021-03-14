package io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AnalizyTest {

    @Test
    public void WhenPairOneSwitchOut() {
        String path1 = "test_Analizy1.csv";
        String path2 = "test_Analizy2.csv";
        Analizy test1 = new Analizy();
        test1.unavailable(path1, path2);
        String result = "";
        try (BufferedReader reader = new BufferedReader(
                new FileReader(path2)
        )){
            var expect = reader.lines().collect(Collectors.toList());
            for (String val:
                 expect) {
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