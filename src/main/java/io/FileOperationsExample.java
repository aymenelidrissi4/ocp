package io;

import java.io.IOException;
import java.nio.file.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileOperationsExample {
    private static final Logger logger = Logger.getLogger(FileOperationsExample.class.getName());

    public static void main(String[] args) {
        // Setup test files and directories
        createTestEnvironment();
        
        // Demonstrate copy operations
        demonstrateCopyOperations();
        
        // Demonstrate move operations
        demonstrateMoveOperations();
        
        // Clean up (comment out to inspect files)
        // cleanupTestEnvironment();
    }

    private static void createTestEnvironment() {
        try {
            // Create source directory with files
            Path sourceDir = Path.of("docs");
            if (!Files.exists(sourceDir)) {
                Files.createDirectory(sourceDir);
                Files.createFile(sourceDir.resolve("file1.txt"));
                Files.createFile(sourceDir.resolve("file2.txt"));
                Files.writeString(sourceDir.resolve("file1.txt"), "Content of file1");
                Files.writeString(sourceDir.resolve("file2.txt"), "Content of file2");
                
                // Create a subdirectory
                Path subDir = sourceDir.resolve("subfolder");
                Files.createDirectory(subDir);
                Files.createFile(subDir.resolve("subfile.txt"));
            }
            
            // Create backup directory
            Path backupDir = Path.of("backup");
            if (!Files.exists(backupDir)) {
                Files.createDirectory(backupDir);
            }
            
            // Create archive directory
            Path archiveDir = Path.of("archive");
            if (!Files.exists(archiveDir)) {
                Files.createDirectory(archiveDir);
            }
            
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error setting up test environment", e);
        }
    }

    private static void demonstrateCopyOperations() {
        Path sourceDir = Path.of("docs");
        Path backupDir = Path.of("backup");
        
        try {
            System.out.println("\n=== COPY OPERATIONS ===");
            
            // 1. Basic file copy
            Path sourceFile = sourceDir.resolve("file1.txt");
            Path targetFile = backupDir.resolve("file1_copy.txt");
            Files.copy(sourceFile, targetFile);
            System.out.println("Basic file copy completed");
            
            // 2. Copy with attributes and replace existing
            Files.copy(sourceFile, targetFile, 
                      StandardCopyOption.COPY_ATTRIBUTES,
                      StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied with attributes preserved");
            
            // 3. Copy directory contents (non-recursive)
            System.out.println("\nCopying directory contents:");
            Files.list(sourceDir).forEach(file -> {
                try {
                    if (!Files.isDirectory(file)) {  // Skip directories
                        Files.copy(file, backupDir.resolve(file.getFileName()),
                                StandardCopyOption.COPY_ATTRIBUTES,
                                StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("Copied: " + file.getFileName());
                    }
                } catch (IOException e) {
                    logger.log(Level.WARNING, "Failed to copy: " + file.getFileName(), e);
                }
            });
            
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error during copy operations", e);
        }
    }

    private static void demonstrateMoveOperations() {
        Path backupDir = Path.of("backup");
        Path archiveDir = Path.of("archive");
        
        try {
            System.out.println("\n=== MOVE OPERATIONS ===");
            
            // 1. Basic file move
            Path fileToMove = backupDir.resolve("file1_copy.txt");
            Path movedFile = archiveDir.resolve("file1_moved.txt");
            Files.move(fileToMove, movedFile);
            System.out.println("Basic file move completed");
            
            // 2. Move with replace existing
            Files.createFile(backupDir.resolve("tempfile.txt"));
            Files.move(
                backupDir.resolve("tempfile.txt"),
                archiveDir.resolve("tempfile.txt"),
                StandardCopyOption.REPLACE_EXISTING
            );
            System.out.println("File moved with replace existing option");
            
            // 3. Atomic move of entire directory
            Path tempBackup = Path.of("temp_backup");
            if (!Files.exists(tempBackup)) {
                Files.createDirectory(tempBackup);
            }
            
            Files.move(
                backupDir,
                archiveDir.resolve("backup"),
                StandardCopyOption.ATOMIC_MOVE,
                StandardCopyOption.REPLACE_EXISTING
            );
            System.out.println("Directory moved atomically");
            
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error during move operations", e);
        }
    }

    private static void cleanupTestEnvironment() {
        try {
            System.out.println("\nCleaning up test environment...");
            deleteRecursively(Path.of("docs"));
            deleteRecursively(Path.of("backup"));
            deleteRecursively(Path.of("archive"));
            deleteRecursively(Path.of("temp_backup"));
        } catch (IOException e) {
            logger.log(Level.WARNING, "Cleanup error", e);
        }
    }

    private static void deleteRecursively(Path path) throws IOException {
        if (Files.exists(path)) {
            if (Files.isDirectory(path)) {
                try (var stream = Files.list(path)) {
                    stream.forEach(p -> {
                        try { deleteRecursively(p); }
                        catch (IOException e) { logger.log(Level.WARNING, "Failed to delete " + p, e); }
                    });
                }
            }
            Files.delete(path);
            System.out.println("Deleted: " + path);
        }
    }
}