package edu.forty.bits.process;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Processes {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        Process process = new ProcessBuilder(List.of("ping", "-i", "1", "-c", "5", "google.com")).inheritIO().start();
        ProcessHandle processHandle = process.toHandle();
        System.out.println(processHandle + " - " + processHandle.info());

        CompletableFuture<ProcessHandle> onExitFuture = processHandle.onExit();
        CompletableFuture<ProcessHandle.Info> infoCompletableFuture = onExitFuture.thenApply(ProcessHandle::info);
        CompletableFuture<Optional<Duration>> optionalCompletableFuture =
                infoCompletableFuture.thenApply(ProcessHandle.Info::totalCpuDuration);
        CompletableFuture<Void> accept = optionalCompletableFuture.thenAccept(System.out::println);
        System.in.read();
    }
}