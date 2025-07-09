package threads;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class ConcurrentCache<K, V> {
    private final Map<K, CacheEntry<V>> cache = new HashMap<>();
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final Lock readLock = rwLock.readLock();
    private final Lock writeLock = rwLock.writeLock();
    
    private final long defaultExpiryMillis;
    private final int maxSize;
    private final boolean evictOnExpiry;

    // Statistics
    private int hitCount = 0;
    private int missCount = 0;
    private int evictionCount = 0;

    private static class CacheEntry<V> {
        final V value;
        final long expiryTime;
        
        CacheEntry(V value, long expiryTime) {
            this.value = value;
            this.expiryTime = expiryTime;
        }
        
        boolean isExpired() {
            return System.currentTimeMillis() > expiryTime;
        }
    }

    public ConcurrentCache(long defaultExpiryMillis, int maxSize, boolean evictOnExpiry) {
        this.defaultExpiryMillis = defaultExpiryMillis;
        this.maxSize = maxSize;
        this.evictOnExpiry = evictOnExpiry;
    }

    public V get(K key) {
        readLock.lock();
        try {
            CacheEntry<V> entry = cache.get(key);
            if (entry == null) {
                missCount++;
                return null;
            }
            
            if (evictOnExpiry && entry.isExpired()) {
                readLock.unlock();
                return remove(key);
            }
            
            if (entry.isExpired()) {
                missCount++;
                return null;
            }
            
            hitCount++;
            return entry.value;
        } finally {
            readLock.unlock();
        }
    }

    public void put(K key, V value) {
        put(key, value, defaultExpiryMillis);
    }

    public void put(K key, V value, long expiryMillis) {
        writeLock.lock();
        try {
            if (cache.size() >= maxSize) {
                evictExpiredEntries();
                if (cache.size() >= maxSize) {
                    K oldestKey = cache.keySet().iterator().next();
                    cache.remove(oldestKey);
                    evictionCount++;
                }
            }
            cache.put(key, new CacheEntry<>(value, System.currentTimeMillis() + expiryMillis));
        } finally {
            writeLock.unlock();
        }
    }

    public V tryGet(K key, long timeout, TimeUnit unit) throws InterruptedException {
        if (!readLock.tryLock(timeout, unit)) {
            return null;
        }
        try {
            CacheEntry<V> entry = cache.get(key);
            if (entry == null) {
                missCount++;
                return null;
            }
            
            if (evictOnExpiry && entry.isExpired()) {
                readLock.unlock();
                return remove(key);
            }
            
            if (entry.isExpired()) {
                missCount++;
                return null;
            }
            
            hitCount++;
            return entry.value;
        } finally {
            readLock.unlock();
        }
    }

    public V remove(K key) {
        writeLock.lock();
        try {
            CacheEntry<V> entry = cache.remove(key);
            return entry != null ? entry.value : null;
        } finally {
            writeLock.unlock();
        }
    }

    public void evictExpiredEntries() {
        if (!writeLock.tryLock()) return;
        
        try {
            int before = cache.size();
            cache.entrySet().removeIf(entry -> entry.getValue().isExpired());
            evictionCount += (before - cache.size());
        } finally {
            writeLock.unlock();
        }
    }

    public int size() {
        readLock.lock();
        try {
            return cache.size();
        } finally {
            readLock.unlock();
        }
    }

    public int getHitCount() { return hitCount; }
    public int getMissCount() { return missCount; }
    public int getEvictionCount() { return evictionCount; }
    public double getHitRate() { 
        return (hitCount + missCount) == 0 ? 0 : (double) hitCount / (hitCount + missCount); 
    }

    public static void main(String[] args) throws InterruptedException {
        ConcurrentCache<String, String> cache = new ConcurrentCache<>(2000, 3, true);

        // Writer thread
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                cache.put("key" + i, "value" + i);
                System.out.println("WRITE: Added key" + i);
                try { Thread.sleep(500); } catch (InterruptedException e) {}
            }
        }).start();

        // Reader thread
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                String value = cache.get("key" + (i % 3));
                System.out.println("READ: key" + (i % 3) + " = " + 
                    (value != null ? value : "MISS"));
                try { Thread.sleep(300); } catch (InterruptedException e) {}
            }
        }).start();

        Thread.sleep(5000);
        
        System.out.println("\nCache Stats:");
        System.out.println("Hits: " + cache.getHitCount());
        System.out.println("Misses: " + cache.getMissCount());
        System.out.println("Evictions: " + cache.getEvictionCount());
        System.out.printf("Hit Rate: %.1f%%\n", cache.getHitRate() * 100);
    }
}