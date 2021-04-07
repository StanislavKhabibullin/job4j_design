package io;

import java.io.*;
import java.nio.file.Path;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<String> sources, String target) {
        Map<String, String> arguments = argumetsRecieves(sources);
        target = arguments.get("-o");
        String f = arguments.get("-e");
        var fMas = f.split("\\.");
        File finalTarget = new File(target);
        var sour = arguments.get("-d");
        var road = pathList(sour, fMas[1]);
        packManyFiles(road, finalTarget);
    }

    public Map<String, String> argumetsRecieves(List<String> masik) {  // вытаскиваем аргументы для работы
        Map<String, String> arguments = new HashMap<>();
        for (int i = 0; i < masik.size(); i++) {
            List<String> mas = Arrays.asList(masik.get(i).split("="));
            arguments.put(mas.get(0), mas.get(1));
        }
        arguments.forEach((key, value) -> {
            System.out.println("key - " + key + " value - " + value);
        });
        return arguments;
    }

    public List<Path> pathList(String directory, String fileExtension) { // определеям пути по которым находятся файлы для архивации
        Search searcher = new Search();
        var ser = searcher.search(Path.of(directory), path -> path.toString()
                .endsWith(fileExtension));
        var road = searcher.search(Path.of(directory), res -> {
            if (ser.contains(res)) {
                return Boolean.parseBoolean(null);
            }
            return res.isAbsolute();
        });
        return road;
    }

    public void packManyFiles(List<Path> paths, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(target)
                )
        )) {
            for (Path path:
                    paths) {
                zip.putNextEntry(new ZipEntry(path.toFile().getPath()));
                try (BufferedInputStream out = new BufferedInputStream(
                        new FileInputStream(path.toFile())
                )) {
                    zip.write(out.readAllBytes());

                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {

        try (FileOutputStream fos = new FileOutputStream(target);
             BufferedOutputStream buf = new BufferedOutputStream(fos);
               ZipOutputStream zip = new ZipOutputStream(buf)
        ){
            ZipEntry notes = new ZipEntry(source.getPath());
            try (BufferedInputStream out = new BufferedInputStream(
                    new FileInputStream(source)
            )){

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
