package io;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;

public class AllInOneHttpExamples {
    public static void main(String[] args) {
        // Modern HTTP Client API (Java 11+)
        System.out.println("=== Modern HTTP Client Example ===");
        httpClientExample();
        
        // Legacy HTTP API (Java 1.0+)
        System.out.println("\n=== Legacy HTTP Example ===");
        legacyHttpExample();
    }

    private static void httpClientExample() {
        try {
            // 1. Download HTML to a file (as shown in the image)
            Path path = Path.of("docs", "index.html");
            Files.createDirectories(path.getParent()); // Create docs directory if needed
            
            URI url = URI.create("http://example.com");
            HttpRequest req = HttpRequest.newBuilder(url).GET().build();
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<Path> res = client.send(req, HttpResponse.BodyHandlers.ofFile(path));
            
            System.out.println("Downloaded to: " + res.body().toAbsolutePath());
            System.out.println("Status code: " + res.statusCode());

            // 2. Simple GET request (additional example)
            HttpRequest simpleReq = HttpRequest.newBuilder()
                .uri(URI.create("https://httpbin.org/get"))
                .GET()
                .build();
                
            HttpResponse<String> simpleRes = client.send(simpleReq, HttpResponse.BodyHandlers.ofString());
            System.out.println("\nSimple GET response:\n" + simpleRes.body());

        } catch (Exception e) {
            System.err.println("HTTP Client error: " + e.getMessage());
        }
    }

    private static void legacyHttpExample() {
        try {
            Path pl = Path.of("docs", "index.txt");
            URL url = new URL("http://example.com");
            
            // Using URL.openStream() with Files.copy
            Files.copy(url.openStream(), pl);
            System.out.println("Downloaded via legacy API to: " + pl.toAbsolutePath());
            
        } catch (IOException e) {
            System.err.println("Legacy HTTP error: " + e.getMessage());
        }
    }
}