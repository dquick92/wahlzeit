package org.wahlzeit.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by daniel on 19.12.16.
 */
public class CacheTest {

    @Test
    public void testSimpleCacheFunctionality() {
        Cache<Integer> cache = new Cache<>();

        int fuenf = cache.find(5);

        assertEquals(1, cache.getCacheSize(), 0);

        int fuenf_new = cache.find(5);
        assertEquals(1, cache.getCacheSize(), 0);

    }

    @Test
    public void testAdvancedCacheFunctionality() {
        Cache<Integer> cache = new Cache<>();

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 10000; j++) {
                int tmp = cache.find(j);
            }
        }

        assertEquals(10000, cache.getCacheSize(), 0);


    }
}

