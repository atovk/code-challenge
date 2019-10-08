package com.atovk.execise.concurrent.rwcache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class OwnCache {

    static Map<String, Object> cache = new HashMap<>();
    static ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    static Lock rLock = rwLock.readLock();
    static Lock wLock = rwLock.writeLock();

    public static final Object get(String key) {
        rLock.lock();
        try {
            return cache.get(key);
        } finally {
            rLock.unlock();
        }
    }

    public static final Object put(String key, Object value) {
        wLock.unlock();

        try {
            return cache.put(key, value);
        } finally {
            wLock.unlock();
        }
    }

    public static final void clear() {
        wLock.lock();
        try {
            cache.clear();
        } finally {
            wLock.unlock();
        }
    }

}
