package io;

import java.io.*;
import java.nio.file.Path;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<String> sources, String target) {
        Map<String, String> arguments = new HashMap<>();
        for (int i = 0; i < sources.size(); i++) {
            List<String> mas = Arrays.asList(sources.get(i).split("="));
            arguments.put(mas.get(0), mas.get(1));
        }
        arguments.forEach((key, value) -> {
            System.out.println("key - " + key + " value - " + value);
        });
        target = arguments.get("-o");
        String f = arguments.get("-e");
        var fMas = f.split("\\.");
        Search searcher = new Search();
        File finalTarget = new File(target);
        var sour = arguments.get("-d");
       var ser = searcher.search(Path.of(sour), path -> path.toString()
                .endsWith(fMas[1]));
       searcher.search(Path.of(sour), res -> {
           if (ser.contains(res)) {
               return Boolean.parseBoolean(null);
           }
           else {
               packSingleFile(res.toFile(), finalTarget);
           }
           return res.isAbsolute();
       }).forEach(System.out::println);

    }

    public void packSingleFile(File source, File target) {

        try (FileOutputStream fos = new FileOutputStream(target);
             BufferedOutputStream buf = new BufferedOutputStream(fos);
               ZipOutputStream zip = new ZipOutputStream(buf)
        ){
            try (BufferedInputStream out = new BufferedInputStream(
                    new FileInputStream(source)
            )){
                ZipEntry notes = new ZipEntry(String.valueOf(target));
                zip.putNextEntry(notes);
                zip.write(out.readAllBytes());
                zip.closeEntry();

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Zip().packSingleFile(new File("./chapter_005/pom.xml"),
        new File("./chapter_005/pom.zip"));
        new Zip().packFiles(Arrays.asList(args), null);
    }
}
