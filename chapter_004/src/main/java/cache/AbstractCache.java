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

    public void put(K key, V value) {
        SoftReference<V> softReference = new SoftReference<V>(value);
      /*  try (PrintWriter fw = new PrintWriter(key.toString())) {
            fw.println(value);
        }

       */
        cache.put(key, softReference);
    }

    public V get(K key) throws IOException {
        SoftReference<V> defaultReferernce = new SoftReference<V>(null);
        V value = cache.getOrDefault(key, defaultReferernce).get(); // если ключ(имя файла) не найдено, то возвращается ссылка на null

        if (value == null) {
            value = load(key);
            put(key, value);
        }
        return load(key);
    }
    protected abstract V load(K key) throws IOException;

}
