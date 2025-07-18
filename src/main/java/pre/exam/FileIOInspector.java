package pre.exam;

import java.io.*;
import java.nio.file.*;
import java.util.Arrays;

public class FileIOInspector {
    public static void main(String[] args) throws IOException {
        byte[] dataBuffer = {0, 1, 2, 3, 4, 5, 6};
        System.out.println("▶ Initial data buffer: " + Arrays.toString(dataBuffer));
        
        Path sourceFile = Path.of("source.dat");
        Path destinationFile = Path.of("destination.dat");
        
        try (OutputStream sourceOut = Files.newOutputStream(sourceFile, StandardOpenOption.CREATE);
             InputStream sourceIn = Files.newInputStream(sourceFile, StandardOpenOption.READ);
             OutputStream destOut = Files.newOutputStream(destinationFile, StandardOpenOption.CREATE)) {
            
            // Phase 1: Write to source file
            System.out.println("\n✎ Writing to source file: " + Arrays.toString(dataBuffer));
            sourceOut.write(dataBuffer);
            sourceOut.flush();
            
            // Phase 2: Read with smaller buffer
            dataBuffer = new byte[4];
            System.out.println("\n🔄 New read buffer (4 bytes): " + Arrays.toString(dataBuffer));
            
            // Phase 3: Copy operation
            System.out.println("\n⎘ Copying data:");
            int bytesRead;
            while ((bytesRead = sourceIn.read(dataBuffer)) != -1) {
                System.out.println("   Read " + bytesRead + " bytes: " + 
                    Arrays.toString(Arrays.copyOf(dataBuffer, bytesRead)));
                
                destOut.write(dataBuffer, 0, bytesRead);
                System.out.println("   Written to destination");
            }
            
            // Verification
            System.out.println("\n✅ Final verification:");
            System.out.println("   Source file: " + Arrays.toString(Files.readAllBytes(sourceFile)));
            System.out.println("   Destination file: " + Arrays.toString(Files.readAllBytes(destinationFile)));
        }
    }
}