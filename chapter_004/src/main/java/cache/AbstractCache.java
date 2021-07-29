package cache;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {
    protected final Map<K, SoftReference<V>> cache = new HashMap<>();
    protected ReferenceQueue queue = new ReferenceQueue();

    public void put(K key, V value) throws FileNotFoundException {
        SoftReference<V> softReference = new SoftReference<V>(value, queue);
        cache.put(key, softReference);
    }

    public V get(K key) throws IOException {

        return cache.get(key).get();
    }
    protected abstract V load(K key) throws IOException;

}
