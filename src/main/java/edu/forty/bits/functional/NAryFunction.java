package edu.forty.bits.functional;

@FunctionalInterface
public interface NAryFunction<T, R> {
    R apply(T... t);
}