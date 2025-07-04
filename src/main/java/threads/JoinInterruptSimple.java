package threads;

public class JoinInterruptSimple {
    public static void main(String[] args) {
        Thread worker = new Thread(() -> {
            try {
                Thread.sleep(5000); // simulate work
            } catch (InterruptedException e) {
                System.out.println("Worker thread interrupted.");
            }
        });

        worker.start();

        Thread interrupter = new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Interrupting main thread...");
                Thread mainThread = Thread.currentThread().getThreadGroup().getParent().activeCount() > 0 ? Thread.currentThread() : null;
                // We will just interrupt the main thread explicitly below instead
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread mainThread = Thread.currentThread();
        interrupter = new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Interrupting main thread...");
                mainThread.interrupt();  // Interrupt main thread
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        interrupter.start();

        try {
            System.out.println("Main thread waiting for worker to finish...");
            worker.join();
            System.out.println("Worker finished.");
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted during join!");
        }
    }
}
