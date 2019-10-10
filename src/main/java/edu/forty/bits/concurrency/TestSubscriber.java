package com.stackoverflow.nullpointer.concurrency;

import java.util.concurrent.Flow;

/**
 * Created by naman.nigam on 18/03/17.
 */
public class TestSubscriber<Integer> implements Flow.Subscriber<Integer> {

    private int lastItem;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        System.out.println("Subscribed");
        lastItem = 0;
    }

    @Override
    public void onNext(Integer item) {

        System.out.println("Received : " + item);
        lastItem += 1; // expect increment by 1
//        assertTrue(lastItem == item);
    }

    @Override
    public void onError(Throwable throwable) {
        // nothing for the moment
    }

    @Override
    public void onComplete() {
        System.out.println("Completed");
    }

    public int getLastItem() {
        return lastItem;
    }
}