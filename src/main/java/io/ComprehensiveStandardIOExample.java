package io;

import java.util.Scanner;

public class ComprehensiveStandardIOExample {
    public static void main(String[] args) {
        // 1. Echo program with exit condition
        echoProgram();
        
        // 2. Reading different data types
        readVariousDataTypes();
        
        // 3. Formatting output examples
        outputFormattingExamples();
        
        // 4. Multi-line input with sentinel
//        multiLineInput();
        
        // 5. Performance comparison
        performanceComparison();
    }

    public static void echoProgram() {
        System.out.println("\n=== Echo Program ===");
        Scanner scanner = new Scanner(System.in);
        String input;
        
        System.out.println("Type anything and I'll echo it back (type 'exit' to quit):");
        
        while (!(input = scanner.nextLine()).equals("exit")) {
            System.out.println("Echo: " + input);
        }
        
        System.out.println("Echo program completed.\n");
    }

    public static void readVariousDataTypes() {
        System.out.println("\n=== Reading Different Data Types ===");
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter an integer: ");
        int integerValue = scanner.nextInt();
        
        System.out.print("Enter a double: ");
        double doubleValue = scanner.nextDouble();
        
        scanner.nextLine(); // Consume remaining newline
        
        System.out.print("Enter a string: ");
        String stringValue = scanner.nextLine();
        
        System.out.print("Enter a boolean (true/false): ");
        boolean booleanValue = scanner.nextBoolean();
        
        System.out.println("\nYou entered:");
        System.out.println("Integer: " + integerValue);
        System.out.println("Double: " + doubleValue);
        System.out.println("String: " + stringValue);
        System.out.println("Boolean: " + booleanValue);
        
        scanner.close();
        System.out.println("Data reading completed.\n");
    }

    public static void outputFormattingExamples() {
        System.out.println("\n=== Output Formatting Examples ===");
        
        String name = "John Doe";
        int age = 30;
        double salary = 75000.50;
        
        // Basic output
        System.out.println("Basic output:");
        System.out.println("Name: " + name + ", Age: " + age + ", Salary: " + salary);
        
        // Formatted output
        System.out.println("\nFormatted output:");
        System.out.printf("Name: %-15s Age: %03d Salary: $%,10.2f%n", name, age, salary);
        
        // Error output
        System.err.println("\nThis is an error message printed to stderr");
        
        System.out.println("Output formatting examples completed.\n");
    }

    public static void multiLineInput() {
        System.out.println("\n=== Multi-line Input ===");
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter multiple lines of text (type 'END' on a new line to finish):");
        
        StringBuilder content = new StringBuilder();
        String line;
        
        while (!(line = scanner.nextLine()).equals("END")) {
            content.append(line).append("\n");
        }
        
        System.out.println("\nYou entered:");
        System.out.println(content.toString());
        
        scanner.close();
        System.out.println("Multi-line input completed.\n");
    }

    public static void performanceComparison() {
        System.out.println("\n=== Performance Comparison ===");
        
        long startTime, endTime;
        
        // Slow method - many I/O operations
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            System.out.println("Line " + i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time taken with individual prints: " + (endTime - startTime) + "ms");
        
        // Fast method - buffered output
        startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            sb.append("Line ").append(i).append("\n");
        }
        System.out.print(sb.toString());
        endTime = System.currentTimeMillis();
        System.out.println("Time taken with buffered output: " + (endTime - startTime) + "ms");
        
        System.out.println("Performance comparison completed.\n");
    }
}