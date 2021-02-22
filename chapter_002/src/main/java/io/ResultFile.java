package io;

import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            out.write("Hellow World! /n".getBytes());
            for (int i = 0; i < 10; i++) {
                out.write(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
