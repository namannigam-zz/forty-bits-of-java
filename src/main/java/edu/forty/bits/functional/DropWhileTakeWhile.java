package com.stackoverflow.nullpointer.functional;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DropWhileTakeWhile {

    public static void main(String[] args) {

        Stream.of("a", "b", "c", "de", "f", "g", "h")
                .peek(System.out::println)
                .takeWhile(s -> s.length() <= 1)
                .collect(Collectors.toList()).forEach(System.out::println);

        Stream.of("a", "b", "c", "de", "f", "g", "h")
                .peek(s -> System.out.print(s + ", "))
                .dropWhile(s -> s.length() <= 1)
                .collect(Collectors.toList()).forEach(System.out::println);

        Stream.of("a", "b", "c", "de", "f", "g", "h")
                .dropWhile(s -> {
                    System.out.println("dropWhile: " + s);
                    return s.length() <= 1;
                })
                .peek(s -> System.out.println("collecting " + s))
                .collect(Collectors.toList()).forEach(System.out::println);
    }
}