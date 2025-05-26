package io;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;

public class IOExample {

    public static void main(String[] args) {
        String binaryInputFile = "binaryInput.dat";
        String binaryOutputFile = "binaryOutput.dat";
        String textInputFile = "textInput.txt";
        String textOutputFile = "textOutput.txt";

        readAndWriteBinary(binaryInputFile, binaryOutputFile);
        readAndWriteCharacters(textInputFile, textOutputFile);
        bufferedLineByLineCopy(textInputFile, "lineCopy.txt");
    }

    // 1. Basic Binary Data Reading and Writing
    public static void readAndWriteBinary(String inputPath, String outputPath) {
        try (InputStream in = new FileInputStream(inputPath);
             OutputStream out = new FileOutputStream(outputPath)) {

            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) != -1) {
                out.write(buffer, 0, length);
            }
            System.out.println("Binary copy completed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 2. Basic Character Data Reading and Writing
    public static void readAndWriteCharacters(String inputPath, String outputPath) {
        Charset utf8 = Charset.forName("UTF-8");
        try (Reader in = new FileReader(inputPath, utf8);
             Writer out = new FileWriter(outputPath, utf8)) {

            char[] buffer = new char[1024];
            int length;
            while ((length = in.read(buffer)) != -1) {
                out.write(buffer, 0, length);
            }
            System.out.println("Character copy completed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 3. BufferedReader and PrintWriter Line-by-Line Copy
    public static void bufferedLineByLineCopy(String inputPath, String outputPath) {
        Charset utf8 = Charset.forName("UTF-8");
        try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(new FileInputStream(inputPath), utf8));
             PrintWriter out = new PrintWriter(
                    new OutputStreamWriter(new FileOutputStream(outputPath), utf8))) {

            String line;
            while ((line = in.readLine()) != null) {
                out.println(line);
            }
            System.out.println("Line-by-line copy completed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
