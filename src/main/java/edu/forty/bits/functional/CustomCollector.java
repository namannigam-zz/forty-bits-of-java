package com.stackoverflow.nullpointer.functional;

import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class CustomCollector<T,A,R> implements Collector<T,A,R> {

    private static final Set<Characteristics> ALL_CHARACTERISTICS =
            Collections.unmodifiableSet(EnumSet.of(Characteristics.CONCURRENT,
                    Characteristics.UNORDERED, Characteristics.IDENTITY_FINISH));

    private final Supplier<A> supplier;
    private final BiConsumer<A, T> accumulator;
    private final BinaryOperator<A> combiner;
    private final Function<A, R> finisher;
    private final Set<Characteristics> characteristics;

    private CustomCollector(Supplier<A> supplier,
                            BiConsumer<A, T> accumulator,
                            BinaryOperator<A> combiner,
                            Function<A, R> finisher,
                            Set<Characteristics> characteristics) {
        this.supplier = supplier;
        this.accumulator = accumulator;
        this.combiner = combiner;
        this.finisher = finisher;
        this.characteristics = characteristics;
    }

    private CustomCollector(Supplier<A> supplier,
                            BiConsumer<A, T> accumulator,
                            BinaryOperator<A> combiner,
                            Set<Characteristics> characteristics) {
        this(supplier, accumulator, combiner, castingIdentity(), characteristics);
    }

    @Override
    public BiConsumer<A, T> accumulator() {
        return accumulator;
    }

    @Override
    public Supplier<A> supplier() {
        return supplier;
    }

    @Override
    public BinaryOperator<A> combiner() {
        return combiner;
    }

    @Override
    public Function<A, R> finisher() {
        return finisher;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return characteristics;
    }

    @SuppressWarnings("unchecked")
    private static <I, R> Function<I, R> castingIdentity() {
        return i -> (R) i;
    }

    public static <T>
    Collector<T, ?, Set<T>> toSet() {
        return new CustomCollector<>((Supplier<Set<T>>) HashSet::new, Set::add,
                (left, right) -> {
                    left.addAll(right);
                    return left;
                },
                ALL_CHARACTERISTICS);
    }
}