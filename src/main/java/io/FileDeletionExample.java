package io;

import java.io.IOException;
import java.nio.file.*;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileDeletionExample {
    private static final Logger logger = Logger.getLogger(FileDeletionExample.class.getName());

    public static void main(String[] args) {
        // Setup test environment similar to the "Lusers" structure
        createTestEnvironment();

        // Path to delete (equivalent to "backup" in the example)
        Path backup = Path.of("joe/backup");

        try {
            System.out.println("Deleting directory and contents: " + backup.toAbsolutePath());
            
            // Walk through the directory tree and delete everything
            Files.walk(backup)
                .sorted(Comparator.reverseOrder()) // Delete children first
                .forEach(path -> {
                    try {
                        System.out.println("Deleting: " + path);
                        Files.delete(path);
                    } catch (IOException ex) {
                        logger.log(Level.SEVERE, "Error deleting " + path, ex);
                    }
                });
            
            System.out.println("Deletion completed successfully");
            
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error walking directory tree", e);
        }
    }

    private static void createTestEnvironment() {
        try {
            // Create directory structure similar to the "Lusers" example
            Path userDir = Path.of("joe");
            Files.createDirectories(userDir);
            
            // Create files and directories
            Files.createDirectories(userDir.resolve("docs"));
            Files.createFile(userDir.resolve("some.txt"));
            Files.createFile(userDir.resolve("other.txt"));
            
            // Create the backup directory with similar content
            Path backupDir = userDir.resolve("backup");
            Files.createDirectories(backupDir);
            Files.createDirectories(backupDir.resolve("docs"));
            Files.createFile(backupDir.resolve("some.txt"));
            Files.createFile(backupDir.resolve("other.txt"));
            
            // Write some content to files
            Files.writeString(userDir.resolve("some.txt"), "Sample content");
            Files.writeString(backupDir.resolve("some.txt"), "Backup content");
            
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error setting up test environment", e);
        }
    }
}