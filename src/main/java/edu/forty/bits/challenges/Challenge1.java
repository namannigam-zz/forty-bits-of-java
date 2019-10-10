package com.stackoverflow.nullpointer.jdk09.challenges;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Challenge1 {

    public static void main(String[] args) {
        Soprano soprano = null;

        Stream.ofNullable(soprano)
                .filter(s -> s.guns.get(0) == null)
                .forEach(s -> System.out.println(s.guns.size()));


        int[] a = {1, 2, 3, 4};
        int sum = IntStream.of(a).sum();

    }

    static class Soprano {
        List<String> guns;

        public Soprano(List<String> guns) {
            this.guns = guns;
        }
    }
}