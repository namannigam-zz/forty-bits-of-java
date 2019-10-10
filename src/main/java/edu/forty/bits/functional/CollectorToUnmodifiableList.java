package com.stackoverflow.nullpointer.functional;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorToUnmodifiableList {

    public static void main(String[] args) {
        var result = Stream.of(1, 2, 3, 4, null, 5)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
        System.out.println(result);

        var result2 = Stream.of(1, 2, 3, 4).collect(Collectors.toUnmodifiableList());
        System.out.println(result2);
    }
}