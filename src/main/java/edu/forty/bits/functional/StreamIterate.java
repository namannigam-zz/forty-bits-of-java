package com.stackoverflow.nullpointer.functional;

import java.util.stream.Stream;

public class StreamIterate {

    public static void main(String[] args) {
        Stream.iterate(1, i -> 2 * i).forEach(System.out::println);

        Stream.iterate(1, i -> i <= 10, i -> 2 * i)
                .forEach(System.out::println);
    }
}