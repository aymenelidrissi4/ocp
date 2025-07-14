package io;

import java.nio.file.*;
import java.nio.file.attribute.*;
import java.io.IOException;
import java.time.Instant;
import java.util.Set;

public class PathPropertiesDemo {
    public static void main(String[] args) throws IOException {
        // Create test files
        Path p1 = Path.of("test_file.txt");
        Files.writeString(p1, "This is a test file");
        
        Path p2 = Path.of("symlink_test.txt");
        Files.createSymbolicLink(p2, p1);

        // Basic file checks
        System.out.println("=== Basic File Properties ===");
        System.out.println("isDirectory: " + Files.isDirectory(p1));
        System.out.println("isExecutable: " + Files.isExecutable(p1));
        System.out.println("isHidden: " + Files.isHidden(p1));
        System.out.println("isReadable: " + Files.isReadable(p1));
        System.out.println("isWritable: " + Files.isWritable(p1));
        System.out.println("isSymbolicLink: " + Files.isSymbolicLink(p2));
        System.out.println("isSameFile: " + Files.isSameFile(p1, p2));
        System.out.println("ContentType: " + Files.probeContentType(p1));

        // File attributes
        System.out.println("\n=== File Attributes ===");
        BasicFileAttributes basicAttrs = Files.readAttributes(p1, BasicFileAttributes.class);
        System.out.println("Size: " + basicAttrs.size() + " bytes");
        System.out.println("Creation: " + basicAttrs.creationTime());
        System.out.println("LastModified: " + basicAttrs.lastModifiedTime());
        System.out.println("LastAccess: " + basicAttrs.lastAccessTime());

        // POSIX attributes (Unix/Linux)
        try {
            PosixFileAttributes posixAttrs = Files.readAttributes(p1, PosixFileAttributes.class);
            System.out.println("\n=== POSIX Attributes ===");
            System.out.println("Owner: " + posixAttrs.owner().getName());
            System.out.println("Group: " + posixAttrs.group().getName());
            System.out.println("Permissions: " + 
                PosixFilePermissions.toString(posixAttrs.permissions()));
        } catch (UnsupportedOperationException e) {
            System.out.println("\nPOSIX attributes not supported on this system");
        }

        // File system information
        System.out.println("\n=== File System Info ===");
        FileSystem fs = p1.getFileSystem();
        System.out.println("Supported attribute views: " + fs.supportedFileAttributeViews());

        // Time conversions
        FileTime creationTime = basicAttrs.creationTime();
        Instant instant = creationTime.toInstant();
        System.out.println("\nCreation time as Instant: " + instant);

        // Cleanup
        Files.delete(p2);
        Files.delete(p1);
    }
}