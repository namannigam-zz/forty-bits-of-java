package edu.forty.bits.functional;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class MutabilityNonNullSize {

    public static void main(String[] args) {

        System.out.println(Stream.empty().spliterator().characteristics());
        System.out.println(Stream.of().spliterator().characteristics());

        System.out.println(LongStream.of().spliterator().characteristics());

        System.out.println(LongStream.range(1, 10).boxed().spliterator().characteristics()); //  Stream<Long>
        System.out.println(LongStream.range(1, 10).spliterator().characteristics());

        System.out.println(LongStream.of(1).spliterator().characteristics());
        System.out.println(LongStream.of(1).peek(System.out::println).spliterator().characteristics());

        System.out.println(LongStream.of(1).skip(0).spliterator().characteristics());
        System.out.println(LongStream.of(1).limit(1).spliterator().characteristics());

        System.out.println(LongStream.of(1).filter(x -> x == 1).spliterator().characteristics());

    }
}