package threads;

class SyncExample {
    private boolean ready = false;

    public synchronized void waitForReady() throws InterruptedException {
        while (!ready) {
            wait();              // Wait releases the lock and pauses here
        }
        System.out.println("Thread resumed because ready is true!");
    }

    public synchronized void setReady() {
        ready = true;
        notify();                 // Wake up one waiting thread
    }
}

public class TestSync {
    public static void main(String[] args) throws InterruptedException {
        SyncExample example = new SyncExample();

        Thread waiter = new Thread(() -> {
            try {
                example.waitForReady();
            } catch (InterruptedException e) {}
        });

        waiter.start();

        Thread.sleep(1000);        // Simulate some work
        example.setReady();        // Notify the waiter thread
    }
}
