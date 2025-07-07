package threads;

import java.util.ArrayList;
import java.util.List;

public class SharedMemoryProblem {
    public static void main(String[] args) {
        // This list is shared between multiple threads and is not thread-safe
        List<String> list = new ArrayList<>(); 

        Runnable r = () -> {
            String name = Thread.currentThread().getName();
            for (int i = 0; i < 5; i++) {
                // Unsafe operation - multiple threads writing concurrently
                list.add(name + " " + i); 
            }
        };

        // Launch 10 threads that will all write to the same list
        for (int i = 0; i < 10; i++) {
            new Thread(r).start();
        }

        // Wait a bit to let threads complete
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Final list size: " + list.size());
    }
}