package pre.exam;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArraysExample {
    public static void main(String[] args) {
        // Initialize an array of integers with both positive and negative values
        Integer[] numbers = {2, -2, 3, -1, 4};
        
        // Sort the array in ascending order
        Arrays.sort(numbers, (num1, num2) -> num1 - num2);
        
        // Convert each number to its absolute value string representation
        String[] numberStrings = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numberStrings[i] = String.valueOf(Math.abs(numbers[i]));
        }
        
        // Create a Set to eliminate duplicates
        Set<String> uniqueNumbers = new HashSet<>(Arrays.asList(numberStrings));
        
        // Print the unique numbers
        System.out.println("Unique absolute values: " + uniqueNumbers);
    }
}