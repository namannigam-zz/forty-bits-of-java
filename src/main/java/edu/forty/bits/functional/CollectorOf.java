package com.stackoverflow.nullpointer.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;

public class CollectorOf {

    public static void main(String[] args) {
        Collector<Integer, List<Integer>, List<Integer>> myCollector =
                Collector.of(ArrayList::new, List::add, (list1, list2) -> {
                    list1.addAll(list2);
                    return list1;
                }, Function.identity(), Collector.Characteristics.values());
    }
}

