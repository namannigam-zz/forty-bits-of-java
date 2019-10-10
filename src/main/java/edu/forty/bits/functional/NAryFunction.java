package com.stackoverflow.nullpointer.functional;

@FunctionalInterface
public interface NAryFunction<T, R> {
    R apply(T... t);
}