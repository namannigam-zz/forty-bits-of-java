package edu.forty.bits.http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;

public class HttpBUG8201238 {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .header("content-type", "application/json;charset=UTF-8")
                .uri(URI.create("http://localhost:9898/swagger#/campaign-v1"))
                .GET()
                .build();

        HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString(Charset.forName("UTF-8")));
    }
}