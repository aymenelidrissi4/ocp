package io;

import java.io.IOException;
import java.nio.file.*;

public class SimpleFileMove {
    public static void main(String[] args) {
        try {
            // Create a source file (for demonstration)
            Path source = Path.of("original.txt");
            Files.writeString(source, "This file will be moved");
            
            // Destination path
            Path destination = Path.of("moved.txt");
            
            // The actual move operation
            Files.move(source, destination);
            
            System.out.println("File moved successfully from " + 
                              source + " to " + destination);
            
        } catch (IOException e) {
            System.out.println("Error moving file: " + e.getMessage());
        }
    }
}