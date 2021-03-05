package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader read = new BufferedReader(
                new FileReader(this.path))){
            read.lines().forEach(s -> {
                List<String> mas = Arrays.asList(s.split(" ").clone());
                String val = "";
                for (int j = 1; j < mas.size(); j++) {
                    val = val + mas.get(j) + " ";
                }
                values.put(mas.get(0), val);
            });

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String value(String key) {
       if (!values.containsKey(key)) {
           throw new IllegalArgumentException();
       }
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(
                new FileReader(this.path))){
            read.lines().forEach(out::add);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        String path = "./chapter_002/app.properties.txt";
        Config test = new Config(path);
        System.out.println(test);
        Config test1 = new Config("./chapter_002/WhenPairWithOutComment.properties.txt");
        test1.load();
        System.out.println(test1.value("name"));
        System.out.println(test1.value("name2"));
    }
}
