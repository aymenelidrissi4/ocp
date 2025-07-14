package io;

import java.io.IOException;
import java.nio.file.*;
import java.util.zip.*;
import java.util.logging.*;

public class ZipExample {
    private static final Logger logger = Logger.getLogger(ZipExample.class.getName());

    public static void main(String[] args) {
        Path joe = Path.of("joe");
        Path zip = Path.of("joe.zip");
        
        try {
            Files.createFile(zip);
            try (ZipOutputStream out = new ZipOutputStream(Files.newOutputStream(zip))) {
                out.setLevel(Deflater.DEFAULT_COMPRESSION);
                Files.walk(joe)
                    .filter(p -> !Files.isDirectory(p))
                    .forEach(p -> {
                        ZipEntry zipEntry = new ZipEntry(joe.relativize(p).toString());
                        try {
                            out.putNextEntry(zipEntry);
                            out.write(Files.readAllBytes(p));
                            out.closeEntry();
                        } catch (Exception e) {
                            logger.log(Level.SEVERE, "Error creating zip entry", e);
                        }
                    });
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error creating zip archive", e);
        }
    }
}