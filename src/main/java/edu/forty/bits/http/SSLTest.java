package edu.forty.bits.http;

import javax.net.ssl.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.time.Duration;

public class SSLTest {
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

    public static void main(String[] args) throws IOException, InterruptedException {
        HttpRequest requestBuilder = HttpRequest.newBuilder()
//                .uri(URI.create("https://163.53.78.120/app/1/game/currentTime"))
                .uri(URI.create("https://games.flipkart.net/app/1/game/currentTime"))
                .GET()
                .build();


        HttpResponse<String> httpResponse = getNewHttpClient().send(requestBuilder, HttpResponse.BodyHandlers.ofString());
        System.out.println(httpResponse.body());
    }
}