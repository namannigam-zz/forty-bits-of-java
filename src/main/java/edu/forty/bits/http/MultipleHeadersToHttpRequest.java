package edu.forty.bits.http;

import java.io.File;
import java.net.URI;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

public class MultipleHeadersToHttpRequest {

    public static void main(String[] args) {
        File myFile = new File("");
        List<String> headers = new ArrayList<>();
        if (myFile.length() > 0) {
            headers.add("Range");
            headers.add("bytes=" + myFile.length() + "-" + args.length);
        }

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://exampleURL.com/aFile"))
                .headers(headers.toArray(String[]::new))
                .build();
    }
}