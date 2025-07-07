package threads;

public class Shared {
    public int x;
    public int y;
}

class VisibilityProblemDemo {
    public static void main(String[] args) {
        Shared s = new Shared();
        
        // Thread 1: Reader thread
        new Thread(() -> {
            while(s.y < 1) {  // May cache s.y value
                int x = s.x;  // Reading x inside loop
            }
            System.out.println("Thread 1 detected y change");
        }).start();

        // Thread 2: Writer thread
        new Thread(() -> {
            s.x = 2;
            s.y = 2;  // Change may not be visible to Thread 1
            System.out.println("Thread 2 updated values");
        }).start();
    }
}