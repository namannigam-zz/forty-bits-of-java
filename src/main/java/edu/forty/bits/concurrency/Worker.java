package edu.forty.bits.concurrency;

import java.util.concurrent.CountDownLatch;

// A class to represent threads for which
// the convertNumbersToName thread waits.
public class Worker extends Thread {
    private int delay;
    private CountDownLatch latch;

    public Worker(int delay, CountDownLatch latch, String name) {
        super(name);
        this.delay = delay;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(delay);
            latch.countDown();
            System.out.println(Thread.currentThread().getName()
                    + " finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}