package io;

import java.nio.file.*;

public class SimpleSymlinkDemo {
    public static void main(String[] args) throws Exception {
        // 1. Create a real file
        Path realFile = Path.of("real.txt");
        Files.writeString(realFile, "Hello"); // Create file with content
        
        // 2. Create symbolic link
        Path link = Path.of("link_to_real.txt");
        Files.createSymbolicLink(link, realFile); // Link -> real.txt

        // 3. Demonstrate checks
        System.out.println("FOLLOW check (target exists): " + Files.exists(link)); // true
        System.out.println("NOFOLLOW check (link exists): " + 
            Files.exists(link, LinkOption.NOFOLLOW_LINKS)); // true
        
        // 4. Read the link target
        Path target = Files.readSymbolicLink(link);
        System.out.println("Link points to: " + target); // prints "real.txt"

        // 5. Break the link by deleting target
        Files.delete(realFile);
        
        System.out.println("\nAfter deleting target:");
        System.out.println("FOLLOW check: " + Files.exists(link)); // false
        System.out.println("NOFOLLOW check: " + 
            Files.exists(link, LinkOption.NOFOLLOW_LINKS)); // true
        System.out.println("Link still points to: " + Files.readSymbolicLink(link)); // still "real.txt"
        
        // Cleanup
        Files.delete(link);
    }
}