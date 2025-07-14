package io;

import java.io.IOException;
import java.nio.file.*;
import java.util.logging.*;
import java.util.zip.*;
import static java.nio.file.FileVisitOption.*;

public class ZipArchiveHandler {
    private static final Logger logger = Logger.getLogger(ZipArchiveHandler.class.getName());

    public static void main(String[] args) {
        Path sourceDir = Path.of("joe");  // Directory to zip
        Path zipFile = Path.of("joe.zip"); // Output zip file

        try {
            createZipArchive(sourceDir, zipFile);
            System.out.println("Successfully created zip archive: " + zipFile.toAbsolutePath());
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to create zip archive", e);
        }
    }

    public static void createZipArchive(Path sourceDir, Path zipFile) throws IOException {
        // Create the zip file if it doesn't exist
        if (!Files.exists(zipFile)) {
            Files.createFile(zipFile);
        }

        try (ZipOutputStream zipOut = new ZipOutputStream(Files.newOutputStream(zipFile))) {
            // Set compression level (0-9)
            zipOut.setLevel(Deflater.DEFAULT_COMPRESSION);

            // Walk through the source directory
            Files.walk(sourceDir)
                .filter(p -> !Files.isDirectory(p)) // Skip directories
                .forEach(file -> {
                    try {
                        // Create relative path for zip entry
                        String relativePath = sourceDir.relativize(file).toString();
                        
                        // Convert path separators to forward slashes for ZIP standard
                        relativePath = relativePath.replace(FileSystems.getDefault().getSeparator(), "/");
                        
                        // Create new zip entry
                        ZipEntry zipEntry = new ZipEntry(relativePath);
                        zipOut.putNextEntry(zipEntry);
                        
                        // Write file content to zip
                        Files.copy(file, zipOut);
                        zipOut.closeEntry();
                        
                        logger.info("Added to zip: " + relativePath);
                    } catch (IOException e) {
                        logger.log(Level.WARNING, "Failed to add file to zip: " + file, e);
                    }
                });
        }
    }
}