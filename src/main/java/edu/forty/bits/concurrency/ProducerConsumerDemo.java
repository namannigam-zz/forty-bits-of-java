package com.stackoverflow.nullpointer.concurrency;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerDemo {
    private static BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(5);

    public static void main(String[] args) throws InterruptedException {
        int noOfProducers = 7;
        int noOfConsumers = 9;
        for (int i = 0; i < noOfProducers; i++) {
            new Thread(new Producer(), "PRODUCER").start();
        }
        for (int i = 0; i < noOfConsumers; i++) {
            new Thread(new Consumer(), "CONSUMER").start();
        }
        System.exit(0);
    }

    static class Producer implements Runnable {
        Random random = new Random();

        public void run() {
            try {
                int num = random.nextInt(100);
                queue.put(num);
                System.out.println("Produced: " + num
                        + " Queue size : " + queue.size());
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("Producer is interrupted.");
            }
        }
    }

    static class Consumer implements Runnable {
        public void run() {
            try {
                System.out.println("Consumed: " + queue.take()
                        + " Queue size : " + queue.size());
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("Consumer is interrupted.");
            }
        }
    }
}