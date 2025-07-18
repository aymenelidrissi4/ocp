package pre.exam;

import java.io.*;
import java.nio.file.*;

public class IOTest {
    public static void main(String[] args) throws IOException {
        byte[] buffer = {0, 1, 2, 3, 4, 5, 6};
        int count = 0;
        Path aFile = Path.of("aFile.txt");
        Path bFile = Path.of("bFile.txt");
        
        try (OutputStream aOut = Files.newOutputStream(aFile, StandardOpenOption.CREATE);
             InputStream aIn = Files.newInputStream(aFile, StandardOpenOption.READ);
             OutputStream bOut = Files.newOutputStream(bFile, StandardOpenOption.CREATE)) {
            
            aOut.write(buffer);
            aOut.flush();
            aOut.close();  // Note: This is redundant in try-with-resources
            
            buffer = new byte[4];
            while ((count = aIn.read(buffer)) != -1) {
                bOut.write(buffer);
            }
        }
    }
}