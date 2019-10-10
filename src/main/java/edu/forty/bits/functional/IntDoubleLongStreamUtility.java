package com.stackoverflow.nullpointer.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntDoubleLongStreamUtility {

    public static void main(String[] args) {

        // intstream map and sum separted out
//        IntStream is = IntStream.of(1, 2, 3, 4);
//        is.map(i -> i + 1);
//        int sum = is.sum();
        IntStream is = IntStream.of(1, 2, 3, 4);
        is = is.map(i -> i + 1);
        int sum = is.sum();

        // array of double from double stream
        Double[] x = DoubleStream.iterate(0.1, i -> i + 0.1)
                .limit(1000)
                .boxed()
                .toArray(Double[]::new);


        // stream generate
        IntStream inStream = Stream.generate(new AtomicInteger(1)::getAndIncrement)
                .limit(10)
                .mapToInt(t -> t);
        inStream.forEach(System.out::println);

        IntStream.generate(new AtomicInteger(1)::getAndIncrement)
                .limit(10)
                .forEach(System.out::println);

        // IntStream iterate
        List<Integer> ints = new ArrayList<>();
        IntStream.iterate(0, i -> i < 5, i -> i + 1).forEach(ints::add);
        System.out.println(ints);

        // while loop to IntStream.iterate
        System.out.println(solutionToCutShortTheNumber(1200));

    }

    private IntStream reverseSort(int from, int to) {
        return IntStream.range(from, to)
                .filter(x -> x % 2 != 0)
                .sorted().map(i -> to - i + from - 1);
    }

    private static int solutionToCutShortTheNumber(int num) {
        return (int) IntStream.iterate(num, i -> i > 0, i -> i % 2 == 0 ? i / 2 : i - 1).count();
    }

    private static IntStream listToIntStream(List<Integer> list) {
        return list.stream().flatMapToInt(IntStream::of);
    }

    private boolean isPrimeJava9(int n) {
        return IntStream.iterate(2, i -> i * i <= n, i -> i + 1)
                .noneMatch(i -> n % i == 0);
    }

    private static void reverseSortAPrimitiveArray(int[] arr2) {
        // careful about boundary values
        int[] sortedArray = Arrays.stream(arr2)
                .map(i -> -i).sorted().map(i -> -i) // just use 'sorted()' for ascending order
                .toArray();
        // safer way to sort
        int[] safeSortedArray = Arrays.stream(arr2)
                .boxed()
                .sorted(Comparator.reverseOrder()) // use 'naturalOrder' for ascending order
                .mapToInt(Integer::intValue)
                .toArray();
        Arrays.sort(arr2);
    }
}