package io;

import java.nio.file.*;
import java.io.IOException;
import java.nio.file.attribute.*;

public class SymbolicLinkTutorial {
    public static void main(String[] args) {
        try {
            // ============================================
            // 1. SETUP: Create test environment
            // ============================================
            Path testDir = Paths.get("symlink_demo");
            Files.createDirectories(testDir);
            
            // Create real file
            Path realFile = testDir.resolve("actual_file.txt");
            Files.writeString(realFile, "Sample content for demonstration");
            
            // Create symbolic link
            Path symLink = testDir.resolve("file_link.txt");
            Files.createSymbolicLink(symLink, realFile);
            
            System.out.println("🛠️ Created test environment:");
            System.out.println(testDir.toAbsolutePath() + "/");
            System.out.println("├── actual_file.txt (real file)");
            System.out.println("└── file_link.txt (symbolic link)\n");

            // ============================================
            // 2. DEMONSTRATE LINK FOLLOWING BEHAVIOR
            // ============================================
            System.out.println("🔎 Existence checks:");
            System.out.printf("Normal check (follows links): %b%n", Files.exists(symLink));
            System.out.printf("NOFOLLOW check: %b%n", 
                Files.exists(symLink, LinkOption.NOFOLLOW_LINKS));

//            System.out.println("\n📊 File attributes:");
//            System.out.printf("Normal size: %d bytes%n", Files.size(symLink));
//            try {
//                System.out.printf("NOFOLLOW size: %d bytes%n",
//                    Files.size(symLink, LinkOption.NOFOLLOW_LINKS));
//            } catch (IOException e) {
//                System.out.println("NOFOLLOW size check failed (expected): " + e.getMessage());
//            }

            // ============================================
            // 3. SHOW BROKEN LINK BEHAVIOR
            // ============================================
            System.out.println("\n💥 Simulating broken link...");
            Files.delete(realFile);
            
            System.out.println("\n🔍 Post-deletion checks:");
            System.out.printf("Normal exists(): %b%n", Files.exists(symLink));
            System.out.printf("NOFOLLOW exists(): %b%n", 
                Files.exists(symLink, LinkOption.NOFOLLOW_LINKS));

        } catch (IOException e) {
            System.err.println("❌ Error: " + e.getMessage());
        } finally {
            // ============================================
            // 4. CLEANUP WITH PROPER ERROR HANDLING
            // ============================================
            try {
                Path testDir = Paths.get("symlink_demo");
                if (Files.exists(testDir)) {
                    // Delete symbolic link first
                    Path symLink = testDir.resolve("file_link.txt");
                    if (Files.exists(symLink, LinkOption.NOFOLLOW_LINKS)) {
                        Files.delete(symLink);
                    }
                    
                    // Delete regular file if it exists
                    Path realFile = testDir.resolve("actual_file.txt");
                    if (Files.exists(realFile)) {
                        Files.delete(realFile);
                    }
                    
                    // Delete directory
                    Files.delete(testDir);
                    System.out.println("\n🧹 Cleanup completed successfully");
                }
            } catch (IOException e) {
                System.err.println("⚠️ Cleanup warning: " + e.getMessage());
            }
        }
    }
}