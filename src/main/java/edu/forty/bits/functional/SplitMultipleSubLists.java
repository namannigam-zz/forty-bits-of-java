package edu.forty.bits.functional;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SplitMultipleSubLists {

    static boolean instanceOfAny(Object obj, Set<Class<?>> set) {
        return set.stream().anyMatch(clazz -> clazz.isInstance(obj));
    }

    static List<Predicate<Object>> predicates = List.of(
            obj -> instanceOfAny(obj, Set.of(Integer.class, Long.class, String.class, Boolean.class)),
            obj -> instanceOfAny(obj, Set.of(Map.class)));

    static int grouper(Object obj) {
        return IntStream.range(0, predicates.size())
                .filter(i -> predicates.get(i).test(obj))
                .findFirst()
                .orElse(predicates.size());
    }

    public static void main(String... args) {
        List<Object> input = List.of(true, 1, 2L, "asdf", Map.of("a", "b"),
                BigInteger.valueOf(23456), Map.of(3, 4), List.of("x", "y", "z"), false, 17, 'q');

        Map<Integer, List<Object>> result =
                input.stream().collect(Collectors.groupingBy(SplitMultipleSubLists::grouper));

        result.forEach((k, v) -> System.out.println(k + " => " + v));
    }
}