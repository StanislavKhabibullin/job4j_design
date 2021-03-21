package io;

import java.io.File;

public class Dir {
    public static void main(String[] args) {
        File file = new File("c:\\projects");
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("file is not exist %s",
                    file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("file is not directory %s",
                    file.getAbsoluteFile()));
        }
        System.out.println(String.format("size : %s",
                file.getTotalSpace()));
        for (File subFile
                : file.listFiles()) {
            System.out.println("file name - " + subFile.getName() + " file size : " + subFile.length());
        }
    }
}
