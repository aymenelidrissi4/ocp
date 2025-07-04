package threads;

public class JoinInterruptExample {
    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
            try {
                System.out.println("Worker thread started, working for 5 seconds...");
                Thread.sleep(5000);
                System.out.println("Worker thread finished work.");
            } catch (InterruptedException e) {
                System.out.println("Worker thread was interrupted during sleep.");
            }
        });

        worker.start();

        Thread interrupter = new Thread(() -> {
            try {
                Thread.sleep(2000);  // Wait 2 seconds before interrupting
                System.out.println("Interrupter thread interrupting main thread.");
                Thread.currentThread().interrupt(); // Interrupt itself for demo (just example)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        interrupter.start();

        try {
            System.out.println("Main thread waiting for worker to finish...");
            worker.join();  // Main thread waits for worker thread
            System.out.println("Worker thread joined normally.");
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted while waiting for worker!");
        }
    }
}
