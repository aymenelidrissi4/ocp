package stream;

import java.util.Spliterator;
import java.util.Random;

public class SpliteratorCharacteristics {
    public static void main(String[] args) {
        // Create Spliterator from random integers stream
        Spliterator<Integer> spliterator = new Random().ints(10, 0, 10).spliterator();
        
        // Check characteristics before splitting
        System.out.println("=== Original Spliterator Characteristics ===");
        printCharacteristics(spliterator);
        
        // Split the Spliterator
        Spliterator<Integer> splitSpliterator = spliterator.trySplit();
        
        // Check characteristics after splitting
        System.out.println("\n=== Main Spliterator After Split ===");
        printCharacteristics(spliterator);
        
        System.out.println("\n=== Split-off Spliterator ===");
        printCharacteristics(splitSpliterator);
    }
    
    private static void printCharacteristics(Spliterator<?> s) {
        String characteristics = 
            "CONCURRENT: " + s.hasCharacteristics(Spliterator.CONCURRENT) + "\n" +
            "DISTINCT:   " + s.hasCharacteristics(Spliterator.DISTINCT) + "\n" +
            "IMMUTABLE:  " + s.hasCharacteristics(Spliterator.IMMUTABLE) + "\n" +
            "NONNULL:    " + s.hasCharacteristics(Spliterator.NONNULL) + "\n" +
            "ORDERED:    " + s.hasCharacteristics(Spliterator.ORDERED) + "\n" +
            "SIZED:      " + s.hasCharacteristics(Spliterator.SIZED) + "\n" +
            "SORTED:     " + s.hasCharacteristics(Spliterator.SORTED) + "\n" +
            "SUBSIZED:   " + s.hasCharacteristics(Spliterator.SUBSIZED);
        
        System.out.println(characteristics);
        System.out.println("Exact size: " + s.getExactSizeIfKnown());
        System.out.println("Estimate size: " + s.estimateSize());
    }
}