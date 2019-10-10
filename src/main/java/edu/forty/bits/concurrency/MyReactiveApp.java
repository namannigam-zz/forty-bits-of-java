package com.stackoverflow.nullpointer.concurrency;

import java.util.List;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyReactiveApp {

    public static void main(String args[]) throws InterruptedException {

        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();

        CustomSubscriber subs = new CustomSubscriber();
        publisher.subscribe(subs);


        List<String> strs = getStrs();

        System.out.println("Publishing Items to Subscriber");
        strs.forEach(publisher::submit);

        /*while (strs.size() != subs.getCounter()) {
            Thread.sleep(10);
        }*/

        //publisher.close();

        System.out.println("Exiting the app");

    }

    private static List<String> getStrs(){

        return Stream.generate(new Supplier<String>() {
            int i =1;
            @Override
            public String get() {
                return "name "+ (i++);
            }
        }).limit(100).collect(Collectors.toList());
    }

}
