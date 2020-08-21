package edu.forty.bits.features;

import javax.net.ssl.*;
import java.io.File;
import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class HttpUtility {

    public static void main(String[] args) throws Exception {
        sample();
        asynchronousHttp();
        synchronousHttp();
        sample();
        startRequest();
        sendRequest(new JSONObject("Hi"));
    }

    // sample request response architecture
    private static void sample() throws IOException, InterruptedException {
        URI uri = URI.create("http://192.168.1.102:8080/");

        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .proxy(ProxySelector.of(new InetSocketAddress("proxy.example.com", 80)))
                .authenticator(Authenticator.getDefault())
                .build();

        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();

        HttpResponse.BodyHandler<String> bodyHandler = responseInfo -> null;
        HttpResponse<String> response = httpClient.send(getRequest, bodyHandler);
        System.out.println("response to get: " + response.body());
    }

    void sampleGET() throws URISyntaxException, IOException, InterruptedException {
        //        Request builder
        URI uri = new URI("http://www.google.com/");
        HttpRequest request = HttpRequest.newBuilder().uri(uri).GET().build();

        //        Client
        HttpClient httpClient = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .build();
        System.out.println(httpClient.version());

        //        Response builder
        HttpResponse response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        int statusCode = response.statusCode();
        String responseBody = response.body().toString();
        System.out.println("statusCode = " + statusCode);
        System.out.println("responseBody = " + responseBody);
    }

    void samplePOST() throws URISyntaxException, IOException, InterruptedException {
        // Request builder
        URI uri = new URI("https://ads.line.me/api/v1.0/authority_delegations/get");
        HttpRequest.BodyPublisher bodyProcessor = HttpRequest.BodyPublishers.ofString("{\"operands\":[]}");
        HttpRequest request = HttpRequest.newBuilder().uri(uri)
                .timeout(Duration.ofMinutes(1))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 1djCb/mXV+KtryMxr6i1bXw")
                .POST(bodyProcessor)
                .build();
        // Client
        HttpClient httpClient = HttpClient.newBuilder().followRedirects(HttpClient.Redirect.ALWAYS).build();
        System.out.println(httpClient.version());

        // Response builder
        HttpResponse.BodyHandler<Path> bodyHandler = HttpResponse.BodyHandlers.ofFile(Paths.get("/path"));
        HttpResponse<Path> response = httpClient.send(request, bodyHandler);
        System.out.println("StatusCode = " + response.statusCode());
        System.out.println("Response = " + response.body().toString());
    }

    // bug in the http implementation
    // https://bugs.openjdk.java.net/browse/JDK-8201238
    void charactersWithUTF8() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .header("content-type", "application/json;charset=UTF-8")
                .uri(URI.create("http://localhost:9898/swagger#/campaign-v1"))
                .GET()
                .build();

        HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString(Charset.forName("UTF-8")));
    }

    private static void asynchronousHttp() {
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest httpRequest = HttpRequest.newBuilder().build();

        httpClient.sendAsync(httpRequest, r -> null)
                .thenApply(response -> {
                    System.out.println(response.statusCode());
                    return response;
                })
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println);
    }

    private static void synchronousHttp() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest httpRequest = HttpRequest.newBuilder().build();

        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());
    }

    // multiple async requests using the http client
    private static void startRequest() throws URISyntaxException, InterruptedException, ExecutionException {
        URI uri = new URI("https://blog.cloudflare.com/announcing-support-for-http-2-server-push-2/");
        HttpRequest request = HttpRequest.newBuilder(uri).version(HttpClient.Version.HTTP_2).GET().build();
        HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
        // TODO : validate later for multi async
//        CompletableFuture<MultiMapResult<String>> sendAsync = client
//                .sendAsync(request, HttpResponse.MultiProcessor.asMap((req) -> {
//                    Optional<HttpResponse.BodyHandler<String>> optional =
//                            Optional.of(HttpResponse.BodyHandler.asString());
//                    String msg = " - " + req.uri();
//                    LOG.log(Level.INFO, msg);
//                    return optional;
//                }))
//                .orTimeout(30, TimeUnit.SECONDS);
//
//        Map<HttpRequest, CompletableFuture<HttpResponse<String>>> multiMapResult = sendAsync.join();
//        LOG.log(Level.INFO, "multiMapResult: " + multiMapResult.entrySet().size());
//
//        for (HttpRequest key : multiMapResult.keySet()) {
//            CompletableFuture<HttpResponse<String>> completableFuture =
//                    multiMapResult
//                            .get(key);
//            HttpResponse<String> response = completableFuture.get();
//            System.out.println(response);
//        }
        System.exit(0);
    }

    // adding multiple headers to the request
    void multipleHeaders() {
        File myFile = new File("");
        List<String> headers = new ArrayList<>();
        if (myFile.length() > 0) {
            headers.add("Range");
            headers.add("bytes=" + myFile.length() + "-" + 4);
        }

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://exampleURL.com/aFile"))
                .headers(headers.toArray(String[]::new))
                .build();
    }

    // sending json objects
    private static JSONObject sendRequest(JSONObject json) throws Exception {
        HttpClient client;
        InetSocketAddress proxy = new InetSocketAddress(8080);

        client = HttpClient.newBuilder().proxy(ProxySelector.of(proxy)).build();

        HttpRequest httpRequest = HttpRequest
                .newBuilder(new URI(""))
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .timeout(Duration.ofHours(2))
                .POST(HttpRequest.BodyPublishers.ofString(json.toString()))
                .build();

        HttpResponse<String> httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        String jsonResponse = httpResponse.body();

        return new JSONObject(jsonResponse);
    }

    static class JSONObject {
        public JSONObject(String jsonResponse) {
            System.out.println(jsonResponse);
        }
    }

    // SSL test for the http client
    private static final X509TrustManager TRUST_MANAGER = new X509TrustManager() {
        public void checkClientTrusted(X509Certificate[] xcs, String string) {
        }

        public void checkServerTrusted(X509Certificate[] xcs, String string) {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    };

    private static HttpClient getNewHttpClient() {
        int timeout = 600;
        try {

            HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);

            SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
            sslContext.init(null, new TrustManager[]{TRUST_MANAGER}, new SecureRandom());

            // Install the all-trusting host verifier
            HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());

            //Set SSL parameters
            SSLParameters parameters = new SSLParameters();
            parameters.setEndpointIdentificationAlgorithm("HTTPS");
            return HttpClient.newBuilder()
                    .connectTimeout(Duration.ofMillis(timeout * 1000))
                    .sslContext(sslContext)
                    .sslParameters(parameters)
                    .build();
        } catch (Exception e) {
            return HttpClient.newHttpClient();
        }
    }

    public static void sslTesting() throws IOException, InterruptedException {
        HttpRequest requestBuilder = HttpRequest.newBuilder()
                .uri(URI.create("https://games.flipkart.net/app/1/game/currentTime"))
                .GET()
                .build();
        HttpResponse<String> httpResponse = getNewHttpClient()
                .send(requestBuilder, HttpResponse.BodyHandlers.ofString());
        System.out.println(httpResponse.body());
    }
}