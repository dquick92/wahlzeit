package org.wahlzeit.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


/**
 * an easy Cache
 * @param <T>: Objects to cache
 */
public class Cache<T> {

    private Map<T,T> valueMap = Collections.synchronizedMap(new HashMap<T,T>());

    public T find(T obj) {

        T item = valueMap.get(obj);

        if (item == null) {
            valueMap.put(obj, obj);
            return obj;
        }
        return item;
    }

    public int getCacheSize() {
        return valueMap.size();
    }
}
















