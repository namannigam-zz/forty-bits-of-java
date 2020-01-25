package edu.forty.bits.records;

import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public record ConstFunction<T,R>(T t, R r)  implements Function<T,R> {
    @Override
    public R apply(T t) {
        return null;
    }

    // trick here is that the name of the variable is same as the abstract methods of interfaces
    record ConstCallable<V>(V call) implements Callable<V> {
    }

    record ConstSupplier<T>(T get) implements Supplier<T> {
    }

    // what it is not meant for
    public record Executor<T>(Supplier<T>supply,Consumer<T>accept) {
    }

    // static fields are allowed
    static String field;
}