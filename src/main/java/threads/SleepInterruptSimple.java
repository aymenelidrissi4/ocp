package threads;

public class SleepInterruptSimple {
    public static void main(String[] args) throws InterruptedException {
        Thread sleeper = new Thread(() -> {
            try {
                System.out.println("Thread going to sleep...");
                Thread.sleep(5000); // Sleep for 5 seconds
                System.out.println("Thread woke up normally.");
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted during sleep!");
            }
        });

        sleeper.start();

        Thread.sleep(2000); // Main thread sleeps 2 seconds
        System.out.println("Main thread interrupts sleeper thread.");
        sleeper.interrupt(); // Interrupt the sleeping thread
    }
}
