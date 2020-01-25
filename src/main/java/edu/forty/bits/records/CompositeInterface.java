package edu.forty.bits.records;


import java.util.concurrent.Callable;
import java.util.function.Supplier;

record CompositeInterface<T, V>(V call,T get) implements Callable<V>, Supplier<T> {}