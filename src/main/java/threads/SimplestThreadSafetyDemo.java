package threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimplestThreadSafetyDemo {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        
        // Thread 1 adds "A" items
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                list.add("A" + i);
            }
        });
        
        // Thread 2 adds "B" items
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                list.add("B" + i);
            }
        });
        
        t1.start();
        t2.start();
        
        t1.join();
        t2.join();
        
        System.out.println("Final list: " + list);
        System.out.println("Expected size: 10 | Actual size: " + list.size());
    }
}