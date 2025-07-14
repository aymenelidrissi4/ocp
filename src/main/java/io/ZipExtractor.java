package io;

import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;
import java.util.zip.*;
import java.util.logging.*;

public class ZipExtractor {
    private static final Logger logger = Logger.getLogger(ZipExtractor.class.getName());

    public static void main(String[] args) {
        Path target = Path.of("extract_to");
        Path zip = Path.of("joe.zip");
        
        try (ZipInputStream in = new ZipInputStream(Files.newInputStream(zip))) {
            ZipEntry e = null;
            while ((e = in.getNextEntry()) != null) {
                Path p = Paths.get(target.toString(), e.getName());
                if (e.isDirectory()) {
                    Files.createDirectories(p);
                } else {
                    logger.info(Arrays.toString(in.readAllBytes()));
                    Files.copy(in, p, StandardCopyOption.REPLACE_EXISTING);
                }
                in.closeEntry();
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error extracting zip archive", e);
        }
    }
}