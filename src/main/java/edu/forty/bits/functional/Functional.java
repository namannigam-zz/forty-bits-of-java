package edu.forty.bits.function;

import java.util.function.Function;

@FunctionalInterface
public interface Functional<E,T extends Number> {

    void perform(E e);

    default void method(E e, T t) {
    }

    default void method(E e, Function<E, T> function) {
    }
}