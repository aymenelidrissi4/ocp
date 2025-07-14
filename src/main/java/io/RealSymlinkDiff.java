package io;

import java.nio.file.*;
import java.io.IOException;

public class RealSymlinkDiff {
    public static void main(String[] args) throws IOException {
        // Setup test structure
        Files.createDirectories(Path.of("test_dir"));
        Files.writeString(Path.of("test_dir/real.txt"), "Content");
        
        // Create a subdirectory and link to it
        Files.createDirectories(Path.of("target_subdir"));
        Files.writeString(Path.of("target_subdir/nested.txt"), "Nested");
        Files.createSymbolicLink(
            Path.of("test_dir/link_to_subdir"), 
            Path.of("target_subdir").toAbsolutePath()
        );

        System.out.println("=== NOFOLLOW (DEFAULT) ===");
        Files.walk(Path.of("test_dir"))
             .forEach(p -> System.out.println("• " + p));

        System.out.println("\n=== FOLLOW_LINKS ===");
        Files.walk(Path.of("test_dir"), FileVisitOption.FOLLOW_LINKS)
             .forEach(p -> System.out.println("• " + p));
        
        // Cleanup
        Files.delete(Path.of("test_dir/link_to_subdir"));
        Files.delete(Path.of("test_dir/real.txt"));
        Files.delete(Path.of("test_dir"));
        Files.delete(Path.of("target_subdir/nested.txt"));
        Files.delete(Path.of("target_subdir"));
    }
}