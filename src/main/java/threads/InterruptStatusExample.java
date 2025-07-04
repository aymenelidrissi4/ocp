package threads;

public class InterruptStatusExample {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Thread was interrupted and status cleared.");
                } else {
                    System.out.println("Thread is not interrupted.");
                }
            }
        });

        thread.start();
        Thread.sleep(1000);  // Allow thread to start
        thread.interrupt();  // Interrupt the thread
    }
}