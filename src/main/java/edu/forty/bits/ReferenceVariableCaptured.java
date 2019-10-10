package com.stackoverflow.nullpointer;

public class ReferenceVariableCaptured {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        Runnable run = new Runnable() {
            @Override
            public void run() {
                Thread.yield();
            }
        };
        Runnable run2 = Thread::yield;
        run.run();
        run2.run();

    }
}