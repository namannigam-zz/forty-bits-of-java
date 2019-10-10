package edu.forty.bits.benchmark;

import java.util.stream.IntStream;

public class PerformanceWithStaticIntStream {

    private static final int SUM = IntStream.range(0, 100).parallel()
            .reduce((n, m) -> n + m)
            .getAsInt();

    public static void main(String[] args) {
        System.out.println(SUM);
    }
}