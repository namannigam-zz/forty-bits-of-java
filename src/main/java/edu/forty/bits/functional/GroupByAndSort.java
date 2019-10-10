package com.stackoverflow.nullpointer.functional;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupByAndSort {

    public static void main(String[] args) {
        List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");

        // 1.1== >Group by a List and display the total count of it
        Map<String, Long> result =
                items.stream().sorted().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("RESULT : " + result);

        // 1.2 Add sorting
        Map<String, Long> finalMap = new LinkedHashMap<>();
        result.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));
        System.out.println("FINAL RESULT : " + finalMap);
    }
}