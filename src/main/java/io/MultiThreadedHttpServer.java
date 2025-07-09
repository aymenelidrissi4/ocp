package io;

import java.io.*;
import java.net.*;

public class MultiThreadedHttpServer {

    public static void main(String[] args) throws IOException {
        int port = 8081;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("HTTP Server is listening on port " + port);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            new Thread(new ClientHandler(clientSocket)).start();
        }
    }

    // Runnable class to handle each HTTP request
    private static class ClientHandler implements Runnable {
        private final Socket clientSocket;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try (
                InputStream input = clientSocket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                OutputStream output = clientSocket.getOutputStream();
                PrintWriter writer = new PrintWriter(output)
            ) {
                // Read the HTTP request line
                String line = reader.readLine();
                if (line != null && !line.isEmpty()) {
                    System.out.println("Received request: " + line);

                    // Send a basic HTTP response
                    writer.println("HTTP/1.1 200 OK");
                    writer.println("Content-Type: text/plain");
                    writer.println("Connection: close");
                    writer.println();
                    writer.println("Hello from Java HTTP server!");
                    writer.flush();
                }

            } catch (IOException e) {
                System.err.println("Error handling client: " + e.getMessage());
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    System.err.println("Error closing client socket: " + e.getMessage());
                }
            }
        }
    }
}
