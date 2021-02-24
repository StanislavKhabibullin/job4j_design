package io;

import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            out.write("Hellow World! \n".getBytes());
            for (int i = 0; i <= 10; i++) {
                for (int j = 0; j <= 10; j++) {

                    out.write(Integer.toString(i).getBytes());
                    out.write('*');
                    out.write(Integer.toString(j).getBytes());
                    out.write('=');
                    int result = i * j;
                    out.write(Integer.toString(result).getBytes());
                    out.write("   \n".getBytes());
                }
                out.write('\n');
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
