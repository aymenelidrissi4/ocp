package pre.exam;

public class Test {
    private int x = 0;
    private int y = 0;

    private synchronized void pause() {
        try {
            this.wait(1000);
        } catch (InterruptedException e) {
            System.out.println("interrupted");
        }
    }

    public static void main(String[] args) {
        Test t = new Test();

        new Thread(() -> {
            while (t.x < 5) {
                t.y++;
            }
        }).start();

        new Thread(() -> {
            t.x = t.y;
        }).start();

        t.pause();
        Thread.currentThread().interrupt();
        System.out.println(t.x + " " + t.y);
    }
}