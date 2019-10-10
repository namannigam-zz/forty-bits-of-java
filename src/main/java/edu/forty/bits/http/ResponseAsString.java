package com.stackoverflow.nullpointer.http;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

import java.net.URI;

import static jdk.incubator.http.HttpResponse.BodyHandler.asString;

public class ResponseAsString {

    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://openjdk.java.net/"))
                .build();
        client.sendAsync(request, asString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
    }
}