package com.stackoverflow.nullpointer.http;

import java.io.IOException;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientTest {

    public static void main(String[] args) throws IOException, InterruptedException {

        URI uri = URI.create("http://192.168.1.102:8080/");

        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .proxy(ProxySelector.of(new InetSocketAddress("proxy.example.com", 80)))
                .authenticator(Authenticator.getDefault())
                .build();

        HttpRequest getRequest = HttpRequest.newBuilder().uri(uri).GET().build();

        HttpResponse.BodyHandler<String> bodyHandler = responseInfo -> null;
        HttpResponse<String> response = httpClient.send(getRequest, bodyHandler);
        System.out.println("response to get: " + response.body());
    }
}