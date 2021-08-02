package cache;

import java.io.*;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

public class DirFileCache extends AbstractCache<String, String> {
    private final String cacheDir;

    public DirFileCache(String cacheDir) {
        this.cacheDir = cacheDir;
    }

    @Override
    protected String load(String key) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (FileReader fr = new FileReader(key)) {
            int i = -1;
            while ((i = fr.read()) !=-1){
                sb.append((char) i);
            }
        }
        return String.valueOf(sb);
    }

    public static void main(String[] args) throws IOException {
                DirFileCache test = new DirFileCache("C:\\projects\\job4j_design\\chapter_004");
                test.put(test.cacheDir + File.separator + "DataTest.txt", "TestDirFileCasche");
                String result = test.get("DataTest.txt");
        System.out.println(result);
        System.out.println(test.get("DataTest.txt"));
    }
}
