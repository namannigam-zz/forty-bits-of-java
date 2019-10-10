package com.stackoverflow.nullpointer.concurrency;

import java.util.Arrays;
import java.util.concurrent.SubmissionPublisher;

/**
 * Source  @see https://community.oracle.com/docs/DOC-1006738
 */
public class TransformDataStreamUsingProcessor {

    public static void main(String[] args) {
        //Create Publisher
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();

        //Create Processor and Subscriber
        MyFilterProcessor<String, String> filterProcessor = new MyFilterProcessor<>(s -> String.valueOf(s.equals("x")));

        MyTransformProcessor<String, Integer> transformProcessor = new MyTransformProcessor<>(s -> Integer.parseInt(s));

        MySubscriber<Integer> subscriber = new MySubscriber<Integer>();

        //Chain Processor and Subscriber
        publisher.subscribe(filterProcessor);
        filterProcessor.subscribe(transformProcessor);
        transformProcessor.subscribe(subscriber);

        System.out.println("Publishing Items...");
        String[] items = {"1", "x", "2", "x", "3", "x"};
        Arrays.stream(items).forEach(publisher::submit);
        publisher.close();
    }
}