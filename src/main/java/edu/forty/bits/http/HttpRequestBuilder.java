package edu.forty.bits.http;

import java.io.FileNotFoundException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.nio.file.Paths;
import java.time.Duration;

public class HttpRequestBuilder {

    HttpRequestBuilder() throws FileNotFoundException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://openjdk.java.net/"))
                .timeout(Duration.ofMinutes(1))
                .header("Content-Type", "application/json")
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofFile(Paths.get("file.json")))
                .build();
    }
}