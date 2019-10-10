package edu.forty.bits.http;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class HttpGet {

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

//        Request builder
        URI uri = new URI("http://www.google.com/");
        HttpRequest request = HttpRequest.newBuilder().uri(uri).GET().build();

//        Client
        HttpClient httpClient = HttpClient.newBuilder().followRedirects(HttpClient.Redirect.ALWAYS).build();
        System.out.println(httpClient.version());

//        Response builder
        HttpResponse response = httpClient.send(request,HttpResponse.BodyHandlers.ofString());

        int statusCode = response.statusCode();
        String responseBody = response.body().toString();
        System.out.println("statusCode = " + statusCode);
        System.out.println("responseBody = " + responseBody);
    }
}