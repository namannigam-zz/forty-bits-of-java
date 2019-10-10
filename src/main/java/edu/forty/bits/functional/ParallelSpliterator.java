package com.stackoverflow.nullpointer.functional;

import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ParallelSpliterator {

    public static void main(String[] args) {
        System.out.println(Stream.of(1L, 2L, 3L).spliterator().characteristics()); //
        System.out.println(Stream.of(1L, 2L, 3L).limit(2).spliterator().characteristics());  // ORDERED
        System.out.println(Stream.of(1L, 2L, 3L).limit(2).parallel().spliterator().characteristics()); // SUBSIZED, ORDERED, SIZED
        Spliterator spliterator = Stream.of(1L, 2L, 3L).limit(2).spliterator();
        Stream stream = StreamSupport.stream(spliterator, true);
        System.out.println(spliterator.characteristics()); // ORDERED
        System.out.println(stream.spliterator().characteristics()); // ORDERED
    }
}