package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

public class TemporaryFilesExample {
    public static void main(String[] args) {
        try {
            // Example 1: Create a temporary directory with default settings
            Path tempDir = Files.createTempDirectory("MyApp_");
            System.out.println("Created temporary directory: " + tempDir);
            
            // Example 2: Create a temporary file inside that directory
            Path tempFile = Files.createTempFile(tempDir, "data_", ".tmp");
            System.out.println("Created temporary file: " + tempFile);
            
            // Example 3: Create a temporary file with specific permissions (POSIX systems)
            try {
                Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rw-r-----");
                FileAttribute<Set<PosixFilePermission>> attr = PosixFilePermissions.asFileAttribute(perms);
                
                Path secureTempFile = Files.createTempFile("secure_", ".tmp", attr);
                System.out.println("Created secure temporary file: " + secureTempFile);
                
                // Do some work with the files...
                Files.writeString(tempFile, "This is temporary data");
                String content = Files.readString(tempFile);
                System.out.println("File content: " + content);
                
                // Clean up the secure file when done
                Files.deleteIfExists(secureTempFile);
            } catch (UnsupportedOperationException e) {
                System.out.println("POSIX file permissions not supported on this system");
            }
            
            // Clean up when done
            Files.deleteIfExists(tempFile);
            Files.deleteIfExists(tempDir);
            System.out.println("Temporary files and directory deleted");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}