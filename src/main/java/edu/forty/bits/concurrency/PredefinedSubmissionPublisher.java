package com.stackoverflow.nullpointer.concurrency;

import java.util.Arrays;
import java.util.concurrent.SubmissionPublisher;

public class PredefinedSubmissionPublisher {

    public static void main(String[] args) {
        //Create Publisher
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();

        //Register Subscriber
        MySubscriber<String> subscriber = new MySubscriber<String>();
        publisher.subscribe(subscriber);

        //Publish items
        System.out.println("Publishing Items...");
        String[] items = {"1", "x", "2", "x", "3", "x"};
        Arrays.stream(items).forEach(publisher::submit);
        publisher.close();
    }
}