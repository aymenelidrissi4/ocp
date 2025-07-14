package io;

import java.nio.file.*;
import java.io.IOException;
import java.util.stream.*;

public class SymbolicLinkDemo {
    public static void main(String[] args) throws IOException {
        // Setup test directory structure
        Path testDir = Paths.get("test_dir");
        Files.createDirectories(testDir);
        
        // Create real file
        Path realFile = testDir.resolve("real.txt");
        Files.write(realFile, "Actual content".getBytes());
        
        // Create symbolic link
        Path linkFile = testDir.resolve("link.txt");
        Files.createSymbolicLink(linkFile, realFile);
        
        System.out.println("=== Directory Structure ===");
        System.out.println(testDir.toAbsolutePath() + "/");
        System.out.println("├── real.txt (real file)");
        System.out.println("└── link.txt (symbolic link to real.txt)\n");

        // 1. NOFOLLOW_LINKS example
        System.out.println("=== NOFOLLOW_LINKS Example ===");
        System.out.println("Checking if link.txt exists (not following links):");
        boolean existsNoFollow = Files.exists(linkFile, LinkOption.NOFOLLOW_LINKS);
        System.out.println("Exists (NOFOLLOW): " + existsNoFollow);
        
        System.out.println("\nFile size (NOFOLLOW):");
        try {
            long size = Files.size(linkFile);
            System.out.println("Size: " + size + " bytes");
        } catch (IOException e) {
            System.out.println("Cannot get size (NOFOLLOW): " + e.getMessage());
        }

        // 2. FOLLOW_LINKS example
        System.out.println("\n=== FOLLOW_LINKS Example ===");
        System.out.println("Checking if link.txt exists (following links):");
        boolean existsFollow = Files.exists(linkFile);
        System.out.println("Exists (FOLLOW): " + existsFollow);
        
//        System.out.println("\nFile size (FOLLOW):");
//        long sizeFollow = Files.size(linkFile);
//        System.out.println("Size: " + sizeFollow + " bytes");

        // 3. Walk examples
        System.out.println("\n=== Directory Walk Examples ===");
        System.out.println("Walking without following links:");
        Files.walk(testDir, 2)
             .forEach(p -> System.out.println(" - " + p.getFileName() + 
                   (Files.isSymbolicLink(p) ? " (symlink)" : "")));
        
        System.out.println("\nWalking following links:");
        Files.walk(testDir, 2, FileVisitOption.FOLLOW_LINKS)
             .forEach(p -> System.out.println(" - " + p.getFileName() + 
                   (Files.isSymbolicLink(p) ? " (symlink)" : "")));

        // Cleanup
        Files.delete(linkFile);
        Files.delete(realFile);
        Files.delete(testDir);
    }
}