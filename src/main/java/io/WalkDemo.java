package io;

import java.nio.file.*;
import java.io.IOException;

public class WalkDemo {
    public static void main(String[] args) throws IOException {
        // Setup test files
        Path dir = Path.of("test_dir");
        Files.createDirectories(dir);
        
        Path realFile = dir.resolve("file.txt");
        Files.writeString(realFile, "Content");
        
        Path symLink = dir.resolve("link_to_file.txt");
        Files.createSymbolicLink(symLink, realFile);

        // 1. Default walk (NOFOLLOW)
        System.out.println("Default walk (NOFOLLOW):");
        Files.walk(dir)
             .forEach(p -> System.out.println("• " + p + 
                     (Files.isSymbolicLink(p) ? " [SYMLINK]" : "")));

        // 2. Walk with FOLLOW_LINKS
        System.out.println("\nWalk with FOLLOW_LINKS:");
        Files.walk(dir, FileVisitOption.FOLLOW_LINKS)
             .forEach(p -> System.out.println("• " + p));
        
        // Cleanup
        Files.delete(symLink);
        Files.delete(realFile);
        Files.delete(dir);
    }
}