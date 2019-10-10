package edu.forty.bits.functional;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FilteringInStreamsAndCollectingStill {

    public static void main(String[] args) {

    }

    private static Map<Integer, List<String>> splitByWords(List<String> list) {
        Map<Integer, List<String>> mapOfElements = new HashMap<>();
        IntStream.range(0, list.size()).forEach(i -> {
            if (list.get(i).length() <= 30) {
                mapOfElements.put(i, Collections.singletonList(list.get(i) + "|"));
            } else if (list.get(i).contains("-")) {
                mapOfElements.put(i, Arrays.stream(list.get(i).split("-")).collect(Collectors.toList()));
            } else {
                mapOfElements.put(i, Collections.singletonList(list.get(i)));
            }
        });

        return mapOfElements;
    }

    private static Map<Integer, List<String>> splitByWordsStream(List<String> list) {
        Map<Integer, List<String>> mapOfElements = IntStream.range(0, list.size())
                .filter(i -> list.get(i).length() > 30 && list.get(i).contains("-"))
                .boxed()
                .collect(Collectors.toMap(Function.identity(),
                        i -> Arrays.stream(list.get(i).split("-"))
                                .collect(Collectors.toList()), (a, b) -> b));

        mapOfElements.putAll(IntStream.range(0, list.size())
                .filter(i -> list.get(i).length() <= 30)
                .boxed()
                .collect(Collectors.toMap(i -> i, i -> Collections.singletonList(list.get(i) + "|"), (a, b) -> b)));

        mapOfElements.putAll(IntStream.range(0, list.size())
                .filter(i -> list.get(i).length() > 30 && !list.get(i).contains("-"))
                .boxed()
                .collect(Collectors.toMap(i -> i, i -> Collections.singletonList(list.get(i)), (a1, b1) -> b1)));

        return mapOfElements;
    }

}