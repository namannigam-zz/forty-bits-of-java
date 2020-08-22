package edu.forty.bits.utilities;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by naman.nigam on 23/03/17.
 */
public class AtomicJDK9 {

    static AtomicInteger ai = new AtomicInteger(0);

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i < 30_000; ++i) {
            sum += atomicIncrement();
        }
        System.out.println(sum);
    }

    public static int atomicIncrement() {
        ai.getAndAdd(12);
        return ai.get();
    }

}