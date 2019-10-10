package com.stackoverflow.nullpointer.functional;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class Sample {

    static <T> Predicate<T> not(Predicate<T> p) {
        return p.negate();
    }

    private static <T> Predicate<T> isNull() {
        return Objects::isNull;
    }

    private static Predicate<String> isEmptyOrNull() {
        return s -> s == null || s.isEmpty();
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("", "one", "two", null, "three");
        strings.stream().filter(isEmptyOrNull()).forEach(System.out::println);
    }
}