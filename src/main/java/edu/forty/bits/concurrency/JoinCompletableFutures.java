package edu.forty.bits.concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class JoinCompletableFutures {

    private static Integer sleepTask(int number) {
        System.out.println(String.format("Task with sleep time %d", number));
        try {
            TimeUnit.SECONDS.sleep(number);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return -1;
        }
        return number;
    }

    public static void main(String[] args) {
        List<Integer> sleepTimes = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println("WITH SEPARATE STREAMS FOR FUTURE AND JOIN");
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        long start = System.currentTimeMillis();
        List<CompletableFuture<Integer>> futures = sleepTimes.stream()
                .map(sleepTime -> CompletableFuture.supplyAsync(() -> sleepTask(sleepTime), executorService)
                        .exceptionally(ex -> -1))
                .collect(Collectors.toList());
        executorService.shutdown();
        List<Integer> result = futures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
        long finish = System.currentTimeMillis();
        System.out.println(String.format("done in %d milliseconds.", finish - start));
        System.out.println(result);

        System.out.println("WITH SAME STREAM FOR FUTURE AND JOIN");
        ExecutorService executorService2 = Executors.newFixedThreadPool(6);
        start = System.currentTimeMillis();
        List<Integer> results = sleepTimes.stream()
                .map(sleepTime -> CompletableFuture.supplyAsync(() -> sleepTask(sleepTime), executorService2)
                        .exceptionally(ex -> -1))
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
        executorService2.shutdown();
        finish = System.currentTimeMillis();
        System.out.println(String.format("done in %d milliseconds.", finish - start));
        System.out.println(results);
    }
}