package com.stackoverflow.nullpointer.http;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;

public class HttpPost {

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        // Request builder
        URI uri = null;
        uri = new URI("https://ads.line.me/api/v1.0/authority_delegations/get");
        HttpRequest.BodyProcessor bodyProcessor = HttpRequest.BodyProcessor.fromString("{\"operands\":[]}");
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

        HttpResponse.BodyHandler bodyHandler = HttpResponse.BodyHandler.asFile(Paths.get("/path"));
        response = httpClient.send(request, HttpResponse.BodyHandler.asString());


        System.out.println("StatusCode = " + response.statusCode());
        System.out.println("Response = " + response.body().toString());
    }
}