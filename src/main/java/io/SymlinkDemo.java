package io;

import java.nio.file.*;
import java.io.IOException;

public class SymlinkDemo {
    public static void main(String[] args) throws IOException {
        // Setup test files (run this once)
        Path dir = Path.of("test_dir");
        Files.createDirectories(dir);
        Path realFile = dir.resolve("real.txt");
        Files.writeString(realFile, "Actual content");
        Path symLink = dir.resolve("link.txt");
        Files.createSymbolicLink(symLink, realFile);

        System.out.println("=== DEFAULT (NOFOLLOW) ===");
        Files.walk(dir)
             .forEach(p -> System.out.println(
                 Files.isSymbolicLink(p) ? p + " [SYMLINK]" : p));

        System.out.println("\n=== FOLLOW_LINKS ===");
        Files.walk(dir, FileVisitOption.FOLLOW_LINKS)
             .forEach(p -> System.out.println(p));

        // Cleanup
        Files.delete(symLink);
        Files.delete(realFile);
        Files.delete(dir);
    }
}