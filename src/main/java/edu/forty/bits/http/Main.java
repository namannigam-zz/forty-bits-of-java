package com.stackoverflow.nullpointer.http;

import jdk.incubator.http.HttpClient;

public class Main {

    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();
        client.executor().execute(() -> System.out.println("Incubator Warning??"));
    }
}