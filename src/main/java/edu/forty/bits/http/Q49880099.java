package com.stackoverflow.nullpointer.http;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.URI;
import java.time.Duration;

public class Q49880099 {

    public static void main(String[] args) throws Exception {
        sendRequest(new JSONObject("Hi"));
    }

    private static JSONObject sendRequest(JSONObject json) throws Exception {
        HttpClient client;
        InetSocketAddress proxy = new InetSocketAddress(8080);

        client = HttpClient.newBuilder().proxy(ProxySelector.of(proxy)).build();

        HttpRequest httpRequest = HttpRequest
                .newBuilder(new URI(""))
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .timeout(Duration.ofHours(2))
                .POST(HttpRequest.BodyPublisher.fromString(json.toString()))
                .build();

        HttpResponse<String> httpResponse = client.send(httpRequest, HttpResponse.BodyHandler.asString());
        String jsonResponse = httpResponse.body();

        return new JSONObject(jsonResponse);
    }
}