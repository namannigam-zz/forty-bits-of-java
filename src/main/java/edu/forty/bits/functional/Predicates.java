package com.stackoverflow.nullpointer.functional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class Predicates {

    private static int totalValues(List<Integer> numbers) {
        int total = 0;
        for (int e : numbers) {
            total += e;
        }
        return total;
    }

    private static int totalEvenValues(List<Integer> numbers) {
        int total = 0;
        for (int e : numbers) {
            if (e % 2 == 0) total += e;
        }
        return total;
    }

    private static int totalOddValues(List<Integer> numbers) {
        int total = 0;
        for (int e : numbers) {
            if (e % 2 != 0) total += e;
        }
        return total;
    }


    /**
     * Predicate usage
     *
     * @param numbers
     * @return
     */
    private static int totalValues(List<Integer> numbers, Predicate<Integer> selector) {
        int total = 0;
        for (int e : numbers) {
            if (selector.test(e)) total += e;
        }
        return total;
    }

    // optimised
    public static int optimisedTotalValues(List<Integer> numbers, Predicate<Integer> selector) {
        return numbers.stream().filter(selector).reduce(0, (c, e) -> c + e);
    }

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println(totalValues(values));
        System.out.println(totalEvenValues(values));
        System.out.println(totalOddValues(values));

        System.out.println(totalValues(values, e -> true));
        System.out.println(totalValues(values, e -> e % 2 == 0));
        System.out.println(totalValues(values, e -> e % 2 != 0));
    }
}
