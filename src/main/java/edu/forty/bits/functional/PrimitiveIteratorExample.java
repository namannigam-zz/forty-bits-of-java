package edu.forty.bits.functional;

import java.util.PrimitiveIterator;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class PrimitiveIteratorExample {

    public static boolean isValidJv8(String number) {
        PrimitiveIterator.OfInt factor = IntStream.iterate(1, i -> 3 - i).iterator();
        int sum = new StringBuilder(number).reverse()
                .toString().chars()
                .map(c -> c - '0')
                .map(i -> i * factor.nextInt())
                .reduce(0, (a, b) -> a + b / 10 + b % 10);
        return (sum % 10) == 0;
    }

    public static boolean isValidJv9(long number) {
        PrimitiveIterator.OfInt factor = IntStream.iterate(1, i -> 3 - i).iterator();
        long sum = LongStream.iterate(number, n -> n > 0, n -> n / 10)
                .map(n -> n % 10)
                .map(i -> i * factor.nextInt())
                .reduce(0, (a, b) -> a + b / 10 + b % 10);
        return (sum % 10) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isValidJv8("100"));
        System.out.println(isValidJv9(100));
    }
}