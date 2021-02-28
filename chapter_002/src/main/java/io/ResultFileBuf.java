package io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class ResultFileBuf {
    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(
                new FileOutputStream("ResultBuf.txt")
        ))){
            out.write("Hellow Word Buf" + '\n');
            out.printf("%s%n", "Some string");
            out.printf("%d%n", 10);
            out.printf("%f%n", 1.5f);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
