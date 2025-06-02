package threads;

public class ThreadInterruptionExample {

    public static void main(String[] args) {
        // Create and start the worker thread
        Thread worker = new Thread(new WorkerTask());
        worker.start();

        try {
            // Let the worker run for 3 seconds
            Thread.sleep(3000);
            
            // Then interrupt it
            worker.interrupt();
            System.out.println("Main thread sent interrupt signal");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class WorkerTask implements Runnable {
        @Override
        public void run() {
            Thread currentThread = Thread.currentThread();
            
            while (!currentThread.isInterrupted()) {
                System.out.println("Worker is working...");
                
                try {
                    // Simulate work by sleeping
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Worker was interrupted while sleeping!");
                    // Restore the interrupt status (good practice)
                    currentThread.interrupt();
                    break; // Exit the loop
                }
            }
            
            System.out.println("Worker thread is stopping gracefully");
        }
    }
}