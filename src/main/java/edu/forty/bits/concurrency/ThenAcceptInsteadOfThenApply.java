package com.stackoverflow.nullpointer.concurrency;

import java.util.concurrent.CompletableFuture;

public class ThenAcceptInsteadOfThenApply {

    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> null).thenApply(result -> {
            System.out.println("SMS sended " + result);
            return null;
        });
    }
}