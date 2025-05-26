package io;

import java.io.*;

public class IOStreamExample {

    public static void main(String[] args) {
        String binaryInput = "binaryInput.dat";
        String binaryOutput = "binaryOutput.dat";
        String textInput = "textInput.txt";
        String textOutput = "textOutput.txt";

        // Create example input files if they don't exist
        createExampleFiles(binaryInput, textInput);

        // Demonstrate binary stream copy
        copyBinaryFile(binaryInput, binaryOutput);

        // Demonstrate character stream copy
        copyTextFile(textInput, textOutput);
    }

    // Copies binary data using InputStream and OutputStream with buffering
    private static void copyBinaryFile(String inputFile, String outputFile) {
        try (
            FileInputStream fis = new FileInputStream(inputFile);
            BufferedInputStream bis = new BufferedInputStream(fis);

            FileOutputStream fos = new FileOutputStream(outputFile);
            BufferedOutputStream bos = new BufferedOutputStream(fos)
        ) {
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

            bos.flush();
            System.out.println("✅ Binary file copied successfully.");
        } catch (IOException e) {
            System.err.println("❌ Error copying binary file: " + e.getMessage());
        }
    }

    // Copies character data using Reader and Writer with buffering
    private static void copyTextFile(String inputFile, String outputFile) {
        try (
            FileReader fr = new FileReader(inputFile);
            BufferedReader br = new BufferedReader(fr);

            FileWriter fw = new FileWriter(outputFile);
            BufferedWriter bw = new BufferedWriter(fw)
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine(); // preserve line breaks
            }

            bw.flush();
            System.out.println("✅ Text file copied successfully.");
        } catch (IOException e) {
            System.err.println("❌ Error copying text file: " + e.getMessage());
        }
    }

    // Utility method to create example input files with dummy data
    private static void createExampleFiles(String binaryFile, String textFile) {
        // Create binary input file
        try (FileOutputStream fos = new FileOutputStream(binaryFile)) {
            fos.write("Hello from binary file!\n".getBytes());
        } catch (IOException e) {
            System.err.println("❌ Error creating binary input file: " + e.getMessage());
        }

        // Create text input file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(textFile))) {
            writer.write("Line 1: Hello, world!");
            writer.newLine();
            writer.write("Line 2: Java I/O streams example.");
            writer.newLine();
        } catch (IOException e) {
            System.err.println("❌ Error creating text input file: " + e.getMessage());
        }
    }
}
