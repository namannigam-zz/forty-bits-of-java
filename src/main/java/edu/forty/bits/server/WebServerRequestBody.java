package edu.forty.bits.server;

import java.util.Map;

public class WebServerRequestBody {

    private String method;
    private Map<String, String> requestParams;
    private String requestBody;
    private String requestUri;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    Map<String, String> getRequestParams() {
        return requestParams;
    }

    void setRequestParams(Map<String, String> requestParams) {
        this.requestParams = requestParams;
    }

    String getRequestBody() {
        return requestBody;
    }

    void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    String getRequestUri() {
        return requestUri;
    }

    void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    @Override
    public String toString() {
        return "WebServerRequestBody{" +
                "method='" + method + '\'' +
                ", requestParams=" + requestParams +
                ", requestBody='" + requestBody + '\'' +
                ", requestUri='" + requestUri + '\'' +
                '}';
    }
}