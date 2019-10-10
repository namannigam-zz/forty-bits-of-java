package com.stackoverflow.nullpointer.optional;

import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class OptionalUtility {

    public static void main(String[] args) {
        OptionalInt i = IntStream.rangeClosed(1, 5)
                .reduce((first, second) -> first == 7 ? first : second);
        System.out.print(i.getAsInt());

        // Find maxProductOfNonOverlappingPalindromes from a stream of integer
        Stream<Integer> integerStream = Stream.of(1, 2);
        Optional<Integer> maxCompare = integerStream.max(Comparator.comparingInt(a -> a));
//        final Optional<Integer> maxCompareTo = integerStream.maxProductOfNonOverlappingPallindromes(Comparator.naturalOrder());


        Optional<Integer> oi = Optional.empty();
        Function<Number, Optional<StringBuilder>> fm = n -> Optional.empty();
        Optional<CharSequence> ocs = oi.flatMap(fm);

        // supplying multiple optional but executing only those present
        Stream<Supplier<Optional<String>>> supplierStream = Stream.of(OptionalUtility::first, OptionalUtility::second);
        Optional<String> s = supplierStream
                .map(Supplier::get)
                .filter(Optional::isPresent)
                .findFirst()
                .flatMap(Function.identity());
        System.out.println(s.get());
    }

    private static Optional<String> first() {
        System.out.println("first");
        return Optional.of("someValue");
    }

    private static Optional<String> second() {
        System.out.println("second");
        return Optional.empty();
    }
}