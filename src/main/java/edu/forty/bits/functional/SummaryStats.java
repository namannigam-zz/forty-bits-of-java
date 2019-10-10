package com.stackoverflow.nullpointer.functional;

import java.util.stream.Stream;

public class SummaryStats {

    public static void main(String[] args) {
        System.out.println(Stream.of(0.55f, 0.45f, 0.5f, 0.65f, 0f).
                filter(i -> i > 0.5).mapToInt(i -> (int) (i * 100 - 50)).summaryStatistics().getCount());
    }
}