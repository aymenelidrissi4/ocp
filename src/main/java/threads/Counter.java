package threads;

import java.util.concurrent.locks.*;

public class Counter {
    private int count = 0;
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private Lock readLock = lock.readLock();
    private Lock writeLock = lock.writeLock();

    // Read operation (many threads can read simultaneously)
    public int getCount() {
        readLock.lock();
        try {
            return count;
        } finally {
            readLock.unlock();
        }
    }

    // Write operation (only one thread can write at a time)
    public void increment() {
        writeLock.lock();
        try {
            count++;
        } finally {
            writeLock.unlock();
        }
    }

    // Example using tryLock
    public boolean safeIncrement() {
        // Try to get the lock immediately
        if (writeLock.tryLock()) {
            try {
                count++;
                return true; // Success!
            } finally {
                writeLock.unlock();
            }
        }
        return false; // Couldn't get the lock
    }
}