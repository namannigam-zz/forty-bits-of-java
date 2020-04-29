package edu.forty.bits.functional;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortArrayWithEvensIntact {

    public static void main(String[] args) {
        Integer[] input = new Integer[]{3, 4, 5, 2, 1, 6, 9, 8, 7, 0};
        Integer[] res = new Integer[]{1, 4, 3, 2, 5, 6, 7, 8, 9, 0};
        Integer[] out = sortArrayStream(input);
        System.out.println(Arrays.equals(out, res));
    }

    static Integer[] sortArrayStream(Integer[] array) {
        Map<Boolean, Map<Integer, Integer>> evenOdds = IntStream.range(0, array.length)
                .boxed()
                .collect(Collectors.partitioningBy(i -> array[i] % 2 == 0,
                        Collectors.toMap(o -> o, i -> array[i])));

        Map<Integer, Integer> oddSorted = remapWithSorting(evenOdds.get(Boolean.FALSE));

        Map<Integer, Integer> overall = new HashMap<>(evenOdds.get(Boolean.TRUE));
        overall.putAll(oddSorted);

        return overall.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toArray(Integer[]::new);
    }


    static Map<Integer, Integer> remapWithSorting(Map<Integer, Integer> initialIndexMapping) {
        List<Integer> oddIndexes = new ArrayList<>(initialIndexMapping.keySet());
        List<Integer> sortedOdds = initialIndexMapping.values().stream()
                .sorted().collect(Collectors.toList());
        return IntStream.range(0, sortedOdds.size())
                .boxed()
                .collect(Collectors.toMap(oddIndexes::get, sortedOdds::get));
    }
}
