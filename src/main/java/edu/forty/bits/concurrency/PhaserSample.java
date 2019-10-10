package edu.forty.bits.concurrency;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class PhaserSample implements Runnable {

    private Phaser phaser;

    private PhaserSample(Phaser phaser) {
        this.phaser = phaser;
        this.phaser.register();  // Question
    }

    @Override
    public void run() {
//         this.phaser.register();  // Question
        print("After register");
        for (int i = 0; i < 2; i++) {
            sleep();
            print("Before await" + i + ":");
            this.phaser.arriveAndAwaitAdvance();
            print("After advance" + i + ":");
        }
    }

    private void sleep() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void print(String msg) {

        System.out.println(String.format("%s: %s, registered=%s, arrived=%s, unarrived=%s, phase=%s.", msg,
                Thread.currentThread().getName(), this.phaser.getRegisteredParties(),
                this.phaser.getArrivedParties(), this.phaser.getUnarrivedParties(), this.phaser.getPhase()));
    }

    public static void main(String[] args) {
        Phaser phaser = new Phaser();
        PhaserSample task = new PhaserSample(phaser);
        Thread t1 = new Thread(task, "t1");
        Thread t2 = new Thread(task, "t2");
        Thread t3 = new Thread(task, "t3");
        t1.start();
        t2.start();
        t3.start();
    }
}