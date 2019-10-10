package edu.forty.bits.http;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Paths;

public class HttpPost {

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        // Request builder
        URI uri = null;
        uri = new URI("https://ads.line.me/api/v1.0/authority_delegations/get");
        HttpRequest.BodyPublisher bodyProcessor = HttpRequest.BodyPublishers.ofString("{\"operands\":[]}");
        HttpRequest request = HttpRequest.newBuilder().uri(uri)
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 1djCb/mXV+KtryMxr6i1bXw")
                .POST(bodyProcessor)
                .build();
        // Client
        HttpClient httpClient = HttpClient.newBuilder().followRedirects(HttpClient.Redirect.ALWAYS).build();
        System.out.println(httpClient.version());

        // Response builder
        HttpResponse response = null;

        HttpResponse.BodyHandler bodyHandler = HttpResponse.BodyHandlers.ofFile(Paths.get("/path"));
        response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());


        System.out.println("StatusCode = " + response.statusCode());
        System.out.println("Response = " + response.body().toString());
    }
}