package edu.forty.bits.concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceScheduling {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        scheduledExecutorService.scheduleAtFixedRate(keepReading(), 1, 5, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(keepWriting(), 1, 5, TimeUnit.SECONDS);
        new BeeperControl().beepForAnHour();
    }

    private static Runnable keepReading() {
        return () -> {
            ;
            Thread thread = Thread.currentThread();
            System.out.println("Hi! Printer here." + " :: " +
                    thread.getName() + " == " + thread.getId() + " :: "+
                    System.currentTimeMillis());
        };
    }

    private static Runnable keepWriting() {
        return () -> {
            Thread thread = Thread.currentThread();
            System.out.println("Hi! Writer here." + " :: " +
                    thread.getName() + " == " + thread.getId() + " :: "+
                    System.currentTimeMillis());        };
    }

    // to beep every ten seconds for two minutes
    static class BeeperControl {
        private final ScheduledExecutorService scheduler =
                Executors.newScheduledThreadPool(1);

        public void beepForAnHour() {
            Runnable beeper = () -> System.out.println("beep");
            ScheduledFuture<?> beeperHandle =
                    scheduler.scheduleAtFixedRate(beeper, 10, 10, TimeUnit.SECONDS);
            Runnable canceller = () -> beeperHandle.cancel(false);
            scheduler.schedule(canceller, 2, TimeUnit.MINUTES);
        }
    }
}