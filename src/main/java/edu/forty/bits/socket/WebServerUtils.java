package edu.forty.bits.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.HashMap;
import java.util.Map;

class WebServerUtils {

    static WebServerRequestBody parseRequest(InputStream input) throws IOException {
        LineNumberReader in = new LineNumberReader(new InputStreamReader(input));
        String inputLine = in.readLine();
        String[] requestCols = inputLine.split("\\s");
        String method = requestCols[0];
        String uri = requestCols[1];
        WebServerRequestBody webServerRequestBody = new WebServerRequestBody();
        webServerRequestBody.setMethod(method);
        if (method.equalsIgnoreCase("GET")) {
            String[] request = uri.split("\\?", 2);
            if (request.length == 2) {
                webServerRequestBody.setRequestUri(request[0]);
                Map<String, String> paramMap = new HashMap<>(parseParams(uri.split("\\?", 2)[1], false));
                webServerRequestBody.setRequestParams(paramMap);
            } else {
                webServerRequestBody.setRequestUri(uri);
            }
        } else if (method.equalsIgnoreCase("POST")) {
            webServerRequestBody.setRequestUri(uri);
            StringBuilder request = new StringBuilder();
            char[] bodyChars = new char[1024];
            while (true) {
                int len;
                if (!in.ready() || (len = in.read(bodyChars)) <= 0) {
                    String[] lines = request.toString().split("\r\n");
                    webServerRequestBody.setRequestBody(lines[lines.length - 1]);
                    break;
                }
                request.append(bodyChars, 0, len);
            }
        }
        return webServerRequestBody;
    }

    private static Map<String, String> parseParams(String params, boolean isPostRequest) {
        String[] paramPairs = params.trim().split("&");
        Map<String, String> paramMap = new HashMap<String, String>();
        for (String paramPair : paramPairs) {
            if (paramPair.contains("=")) {
                String[] keyValue = paramPair.split("=");
                String value = keyValue[1];
                if (isPostRequest) {
                    value = value.replace("+", " ");
                }
                paramMap.put(keyValue[0], value);
            }
        }
        return paramMap;
    }


    static Boolean isPostRequest(WebServerRequestBody webServerRequestBody) {
        return webServerRequestBody.getMethod() != null && webServerRequestBody.getMethod().equalsIgnoreCase("POST");
    }

    static Boolean isGetRequest(WebServerRequestBody webServerRequestBody) {
        return webServerRequestBody.getMethod() != null && webServerRequestBody.getMethod().equalsIgnoreCase("GET");
    }
}