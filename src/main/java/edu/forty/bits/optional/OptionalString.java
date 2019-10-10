package com.stackoverflow.nullpointer.optional;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

public final class OptionalString {

    private static final OptionalString EMPTY = new OptionalString();

    private final boolean isPresent;
    private final String value;

    private OptionalString() {
        this.isPresent = false;
        this.value = "";
    }

    private static OptionalString empty() {
        return EMPTY;
    }

    private boolean isPresent() {
        return isPresent;
    }

    private OptionalString(String value) {
        this.isPresent = true;
        this.value = value;
    }

    public static OptionalString of(String value) {
        return value == null || value.isEmpty() ? OptionalString.empty() : new OptionalString(value);
    }

    public OptionalString map(Function<? super String, ? extends String> mapper) {
        return !isPresent() ? OptionalString.empty() : OptionalString.of(mapper.apply(this.value));
    }

    public OptionalString or(Supplier<String> supplier) {
        return isPresent() ? this : OptionalString.of(supplier.get());
    }

    String orElse(String other) {
        return isPresent ? value : other;
    }

    public String getAsString() {
        return Optional.of(value).orElseThrow(() -> new NoSuchElementException("No value present"));
    }
}