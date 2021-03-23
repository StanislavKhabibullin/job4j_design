package io;

import java.io.File;

public class Dir {
    public static void main(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
        }
        File file = new File(args[0]);
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
