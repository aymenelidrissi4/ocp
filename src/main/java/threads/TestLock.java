package threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class LockExample {
    private boolean conditionA = false;
    private boolean conditionB = false;

    private final Lock lock = new ReentrantLock();
    private final Condition condA = lock.newCondition();
    private final Condition condB = lock.newCondition();

    public void waitForConditionA() throws InterruptedException {
        lock.lock();
        try {
            while (!conditionA) {
                condA.await();        // Wait on condition A
            }
            System.out.println("Thread resumed because condition A is true!");
        } finally {
            lock.unlock();
        }
    }

    public void waitForConditionB() throws InterruptedException {
        lock.lock();
        try {
            while (!conditionB) {
                condB.await();        // Wait on condition B
            }
            System.out.println("Thread resumed because condition B is true!");
        } finally {
            lock.unlock();
        }
    }

    public void signalConditionA() {
        lock.lock();
        try {
            conditionA = true;
            condA.signal();           // Wake up threads waiting on condition A
        } finally {
            lock.unlock();
        }
    }

    public void signalConditionB() {
        lock.lock();
        try {
            conditionB = true;
            condB.signal();           // Wake up threads waiting on condition B
        } finally {
            lock.unlock();
        }
    }
}

public class TestLock {
    public static void main(String[] args) throws InterruptedException {
        LockExample example = new LockExample();

        Thread waiterA = new Thread(() -> {
            try {
                example.waitForConditionA();
            } catch (InterruptedException e) {}
        });

        Thread waiterB = new Thread(() -> {
            try {
                example.waitForConditionB();
            } catch (InterruptedException e) {}
        });

        waiterA.start();
        waiterB.start();

        Thread.sleep(1000);

        example.signalConditionA();   // Only wakes waiterA
        Thread.sleep(500);
        example.signalConditionB();   // Only wakes waiterB
    }
}
