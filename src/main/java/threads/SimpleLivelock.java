package threads;

public class SimpleLivelock {
    static class Partner {
        private boolean hasTurn = true;

        public synchronized boolean isMyTurn() {
            return hasTurn;
        }

        public synchronized void giveTurn() {
            hasTurn = !hasTurn;
        }
    }

    public static void main(String[] args) {
        Partner p1 = new Partner();

        Thread t1 = new Thread(() -> {
            while (true) {
                if (p1.isMyTurn()) {
                    System.out.println("Thread 1: Giving turn to Thread 2");
                    p1.giveTurn();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            while (true) {
                if (!p1.isMyTurn()) {
                    System.out.println("Thread 2: Giving turn to Thread 1");
                    p1.giveTurn();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
