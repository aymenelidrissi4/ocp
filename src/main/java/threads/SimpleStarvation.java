package threads;

public class SimpleStarvation {
    public static void main(String[] args) {
        Object lock = new Object();

        // Low-priority thread (simulated)
        Thread lowPriority = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    System.out.println("Low-priority thread running");
                    try { Thread.sleep(100); } catch (Exception ignored) {}
                }
            }
        });

        // High-priority threads that keep taking the lock
        for (int i = 0; i < 5; i++) {
            Thread highPriority = new Thread(() -> {
                while (true) {
                    synchronized (lock) {
                        System.out.println("High-priority thread running");
                        try { Thread.sleep(50); } catch (Exception ignored) {}
                    }
                }
            });
            highPriority.setDaemon(true); // So they don’t block JVM exit
            highPriority.start();
        }

        lowPriority.start();
    }
}
