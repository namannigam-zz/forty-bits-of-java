package com.stackoverflow.nullpointer.http;

import jdk.incubator.http.HttpClient;

import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.ProxySelector;

public class HttpClientBuilder {

    HttpClientBuilder() {
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .followRedirects(HttpClient.Redirect.SAME_PROTOCOL)
                .proxy(ProxySelector.of(new InetSocketAddress("www-proxy.com", 8080)))
                .authenticator(Authenticator.getDefault())
                .build();

    }
}