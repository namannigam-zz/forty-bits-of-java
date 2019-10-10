package com.stackoverflow.nullpointer.functional;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class ListMapTransformation {

    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<>();
        List<String> list = Arrays.asList("one", "two", "three", "four");

        System.out.println(IntStream.range(0, list.size())
                .boxed()
                .collect(groupingBy(
                        i -> i % 2 == 0 ? "even" : "odd",
                        mapping(list::get, toList())
                )));

        System.out.println(IntStream.range(0, list.size())
                .boxed()
                .collect(partitioningBy(
                        i -> i % 2 == 0,
                        mapping(list::get, toList())
                )));
    }
}