package threads;

class WaitNotifyExample {
    private final Object lock = new Object();
    private boolean isReady = false;

    public void waitForReady() throws InterruptedException {
        synchronized (lock) {
            while (!isReady) {
                System.out.println(Thread.currentThread().getName() + " is waiting...");
                lock.wait();  // Releases the lock and waits
            }
            System.out.println(Thread.currentThread().getName() + " resumed, isReady = " + isReady);
        }
    }

    public void setReady() {
        synchronized (lock) {
            isReady = true;
            System.out.println(Thread.currentThread().getName() + " sets isReady to true and notifies.");
            lock.notify();  // Wakes up one waiting thread
        }
    }
}

public class TestWaitNotify {
    public static void main(String[] args) throws InterruptedException {
        WaitNotifyExample example = new WaitNotifyExample();

        Thread waiter = new Thread(() -> {
            try {
                example.waitForReady();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "WaiterThread");

        waiter.start();

        Thread.sleep(2000);  // Simulate some work before setting ready

        Thread notifier = new Thread(() -> {
            example.setReady();
        }, "NotifierThread");

        notifier.start();

        waiter.join();
        notifier.join();
    }
}
