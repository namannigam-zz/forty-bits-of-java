package com.stackoverflow.nullpointer.concurrency;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Function;

/**
 * The Processor
 * A component that acts as both a Subscriber and Publisher.
 * The processor sits between the Publisher and Subscriber, and transforms one stream to another.
 * There could be one or more processor chained together, and the result of the final processor in the chain, is processed by the Subscriber.
 * @param <T> the subscribed item type
 * @param <R> the published item type
 */
public class MyTransformProcessor<T, R> extends SubmissionPublisher<R> implements Flow.Processor<T, R> {

    private final Function function;
    private Flow.Subscription subscription;

    public MyTransformProcessor(Function<? super T, ? extends R> function) {
        super();
        this.function = function;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(T item) {
        submit((R)function.apply(item));
        subscription.request(1);
    }

    @Override
    public void onError(Throwable t) {
        t.printStackTrace();
    }

    @Override
    public void onComplete() {
        close();
    }
}