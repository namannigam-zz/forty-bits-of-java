package com.stackoverflow.nullpointer.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunAsyncVsForEach {

    public static void main(String[] args) {
        List<Runnable> tasks = new ArrayList<>();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        tasks.forEach(executorService::execute); // Each task sends an email to an user
        executorService.shutdown(); // Reclaim all the resources

        // After some research I've found a new way, using Java 8 CompletableFuture.runAsync(...) method.
        ExecutorService executor = Executors.newSingleThreadExecutor();
        tasks.forEach(task -> CompletableFuture.runAsync(task, executor));
        executor.shutdown(); // Reclaim all resources
    }
}