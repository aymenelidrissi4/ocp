package io;

import java.nio.file.*;
import java.io.IOException;

public class SymlinkTruth {
    public static void main(String[] args) throws IOException {
        Path dir = Path.of("test_dir");
        
        // Setup
        Files.createDirectories(dir);
        Path real = dir.resolve("real.txt");
        Files.writeString(real, "Content");
        Path link = dir.resolve("link.txt");
        Files.createSymbolicLink(link, real);

        System.out.println("=== NOFOLLOW (DEFAULT) ===");
        Files.walk(dir)
             .forEach(p -> System.out.println(
                 p + (Files.isSymbolicLink(p) ? " [SYMLINK]" : "")));

        System.out.println("\n=== FOLLOW_LINKS (TRUTH) ===");
        Files.walk(dir, FileVisitOption.FOLLOW_LINKS)
             .forEach(p -> System.out.println(
                 p + (Files.isSymbolicLink(p) ? " [SYMLINK]" : "")));
        
        // Cleanup
        Files.delete(link);
        Files.delete(real);
        Files.delete(dir);
    }
}