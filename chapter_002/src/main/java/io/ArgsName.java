package io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        if (!values.containsKey(key)) {
            throw new IllegalArgumentException();
        }
        return values.get(key);
    }

    private void parse(String[] args) {
        if (args == null) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < args.length; i++) {
            var mas = args[i].split("=");
            if (mas.length != 2) {
                throw new IllegalArgumentException();
            }
            var key = mas[0].split("-");
            var value = mas[1];
            if (key == null || value == null) {
                throw new IllegalArgumentException();
            }
            values.put(key[1], value);
        }

    }

    public static ArgsName of(String[] args) {
        if (args == null) {
            throw new IllegalArgumentException();
        }
        ArgsName name = new ArgsName();
        name.parse(args);
        return name;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}
