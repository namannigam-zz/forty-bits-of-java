package com.stackoverflow.nullpointer.functional;

import java.util.*;

public class SortMapByKeyThenValues {

    public static void main(String[] args) {
        Map<Integer, List<Integer>> yourMap = new HashMap<>();
        Map<Integer, List<Integer>> sortedByKey = new TreeMap<>(yourMap);
        sortedByKey.values().forEach(Collections::sort);
    }
}