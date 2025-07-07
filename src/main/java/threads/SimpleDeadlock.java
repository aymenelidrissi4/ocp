package threads;

public class SimpleDeadlock {
    private static final Object lockA = new Object();
    private static final Object lockB = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (lockA) {
                System.out.println(Thread.currentThread().getName() + ": locked A");
                try { Thread.sleep(100); } catch (Exception ignored) {}
                synchronized (lockB) {
                    System.out.println(Thread.currentThread().getName() + ": locked B");
                }
            }
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + ": locked B");
                try { Thread.sleep(100); } catch (Exception ignored) {}
                synchronized (lockA) {
                    System.out.println(Thread.currentThread().getName() + ": locked A");
                }
            }
        }, "Thread-2");

        t1.start();
        t2.start();
    }
}
