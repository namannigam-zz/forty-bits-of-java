package edu.forty.bits.concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

// https://stackoverflow.com/questions/58791345/
public class ShutdownExecutorForAnyTaskCancelled {

  void shutdownExecServiceForAnyTaskFailure() throws InterruptedException {
    Runnable task1 = () -> {};
    Runnable task2 = () -> {};

    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
    ScheduledFuture<?> task1schedule =
        scheduledExecutorService.scheduleAtFixedRate(task1, 1, 60, TimeUnit.SECONDS);
    ScheduledFuture<?> task2schedule =
        scheduledExecutorService.scheduleAtFixedRate(task2, 1, 60, TimeUnit.SECONDS);
    scheduledExecutorService.awaitTermination(1, TimeUnit.MINUTES);
    if (task1schedule.isCancelled() || task2schedule.isCancelled())
      scheduledExecutorService.shutdown();
  }
}