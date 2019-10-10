package com.stackoverflow.nullpointer.concurrency;


import java.util.List;
import java.util.concurrent.SubmissionPublisher;

public class PublisherSubscriber {

    public void testReactiveStreams() {
        //Create Publisher
        SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>();

        //Register Subscriber
        TestSubscriber<Integer> subscriber = new TestSubscriber<>();
        publisher.subscribe(subscriber);

        assert (publisher.hasSubscribers());

        //Publish items
        System.out.println("Publishing Items...");

        List.of(1, 2, 3, 4, 5).forEach(i -> {
            publisher.submit(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // blah
            }
        });
        assert (5 == subscriber.getLastItem());

        publisher.close();
    }

    public static void offer() throws InterruptedException {
        //Create Publisher for expected items Strings
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
        //Register Subscriber
        publisher.subscribe(new TestSubscriber<>());
        publisher.subscribe(new TestSubscriber<>());
        publisher.subscribe(new TestSubscriber<>());
        publisher.offer("item", (subscriber, value) -> false);
        Thread.sleep(500);
    }
}