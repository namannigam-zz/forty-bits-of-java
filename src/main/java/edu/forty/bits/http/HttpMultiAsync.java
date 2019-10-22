package edu.forty.bits.http;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HttpMultiAsync {

    private static final Logger LOG = Logger.getLogger(HttpMultiAsync.class.getName());

    public static void main(String[] args) {
        try {
            LOG.log(Level.INFO, "");
            LOG.log(Level.INFO, "");
            LOG.log(Level.INFO, "##################################################");
            LOG.log(Level.INFO, "The following resources were pushed by the server:");
            HttpMultiAsync httpMultiAsync = new HttpMultiAsync();
            httpMultiAsync.startRequest();
            System.exit(0);
        } catch (URISyntaxException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private void startRequest() throws URISyntaxException, InterruptedException,
            ExecutionException {

        URI uri = new URI(
                "https://blog.cloudflare.com/announcing-support-for-http-2-server-push-2/");
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
}