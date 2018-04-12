package guava.cache;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHMCacheTest<K, V> {

    private final ConcurrentHashMap<K, V> cacheMap = new ConcurrentHashMap<>();

    private Object getCache(K key, String threadName) {

        System.out.println(threadName + " getCache ===========");
        Object value = cacheMap.get(key);
        if(value==null) {
            return putCache(key,threadName);
        }
        return value;
    }

    private Object putCache(K key, String value) {
        return cacheMap.put(key, (V)value);
    }
}
