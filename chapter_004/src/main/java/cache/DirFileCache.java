package cache;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

public class DirFileCache extends AbstractCache<String, String> {
    private final String cacheDir;

    public DirFileCache(String cacheDir) {
        this.cacheDir = cacheDir;
    }

  @Override
    public void put(String key, String value) throws FileNotFoundException {
        try (PrintWriter fw = new PrintWriter(cacheDir + "\\" + key)){
            fw.println(value);
        }
    }

    @Override
    public String get(String key) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (FileReader fr = new FileReader(cacheDir + "\\" + key)) {
            int i = -1;
            while ((i = fr.read()) !=-1){
                sb.append((char) i);
            }
        }
        return String.valueOf(sb);
    }

    @Override
    protected String load(String key) throws IOException {
        return get(key);
    }

    public static void main(String[] args) throws IOException {
                DirFileCache test = new DirFileCache("C:\\projects\\job4j_design\\chapter_004");
                test.put("DataTest.txt", "Hello word!");
                String result = test.get("DataTest.txt");
        System.out.println(result);
        System.out.println(test.load("DataTest.txt"));
    }
}
