package pre.exam;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeExample {
    public static void main(String[] args) {
        int[] values = {-1, -2, 0, 2, 1};
        Deque<Integer> numbers = new ArrayDeque<>();
        
        for (int i = 0; i < values.length; i++) {
            if (i % 2 == 0) {  // Corrected condition (even index)
                numbers.offerFirst(values[i]);  // Add to front
            } else {
                numbers.offerLast(values[i]);   // Add to end
            }
            System.out.println("Step " + i + ": " + numbers);  // Debug output
        }
        
        System.out.println("Final Result: " + numbers);  // Final result
    }
}