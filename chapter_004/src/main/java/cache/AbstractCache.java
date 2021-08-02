package cache;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {
    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) throws IOException {
        SoftReference<V> softReference = new SoftReference<V>(value);
        try (PrintWriter fw = new PrintWriter(key.toString())) {
            fw.println(value);
        }
        cache.put(key, softReference);
    }

    public V get(K key) throws IOException {

        return load(key);
    }
    protected abstract V load(K key) throws IOException;

}
