package org.example;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.logging.*;

public class MultiHandlerLoggingExample {

    // Create a Logger
    private static final Logger LOGGER = Logger.getLogger(MultiHandlerLoggingExample.class.getName());

    public static void main(String[] args) {
        try {
            setupLogger();

            // Log messages at different levels
            LOGGER.severe("SEVERE message: Serious problem occurred!");
            LOGGER.warning("WARNING message: Something might go wrong.");
            LOGGER.info("INFO message: Just an informational message.");
            LOGGER.config("CONFIG message: Configuration detail.");
            LOGGER.fine("FINE message: Tracing detail.");
            LOGGER.finer("FINER message: Finer tracing.");
            LOGGER.finest("FINEST message: Finest tracing.");

            Enumeration<String> loggerNames = (Enumeration<String>) LogManager.getLogManager().getLoggerNames();

            // Print the names of all loggers
            System.out.println("Loggers created in the system:");
            while (loggerNames.hasMoreElements()) {
                String loggerName = loggerNames.nextElement();
                System.out.println(loggerName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void setupLogger() throws IOException {
        // Turn off the default console handler
        LogManager.getLogManager().reset();

        // Create a ConsoleHandler
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.WARNING); // Only show WARNING and SEVERE on console
        consoleHandler.setFormatter(new SimpleFormatter()); // Simple text format

        // Create a FileHandler
        FileHandler fileHandler = new FileHandler("application.log", true); // Append mode
        fileHandler.setLevel(Level.INFO); // Log INFO and above to the file
        fileHandler.setFormatter(new SimpleFormatter()); // Simple text format

        // Create another FileHandler for only SEVERE messages
        FileHandler severeHandler = new FileHandler("severe.log", true);
        severeHandler.setLevel(Level.SEVERE); // Only SEVERE messages
        severeHandler.setFormatter(new XMLFormatter()); // Save as XML format

        // Attach handlers to the logger
        LOGGER.addHandler(consoleHandler);
        LOGGER.addHandler(fileHandler);
        LOGGER.addHandler(severeHandler);

        // Set the Logger's level to the lowest so that all messages can be handled
        LOGGER.setLevel(Level.ALL);
    }
}
