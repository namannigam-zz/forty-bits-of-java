package edu.forty.bits.http;

import java.net.http.HttpHeaders;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.Flow;

public class ReactiveHttp {

    public abstract static class HttpRequest {

        public interface BodyPublisher
                extends Flow.Publisher<ByteBuffer> {
        }
    }

    public abstract static class HttpResponse<T> {

        public interface BodyHandler<T> {
            BodySubscriber<T> apply(int statusCode, HttpHeaders responseHeaders);
        }

        interface BodySubscriber<T>
                extends Flow.Subscriber<List<ByteBuffer>> {
        }
    }
}