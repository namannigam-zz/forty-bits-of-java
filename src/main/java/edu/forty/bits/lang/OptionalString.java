package com.stackoverflow.nullpointer.lang;

import java.util.NoSuchElementException;
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

    private OptionalString(String value) {
        this.isPresent = true;
        this.value = value;
    }


    static OptionalString of(String value) {
        return value == null || value.isEmpty() ? OptionalString.empty() : new OptionalString(value);
    }

    OptionalString map(Function<? super String, ? extends String> mapper) {
        if (!isPresent()) {
            return OptionalString.empty();
        } else {
            return OptionalString.of(mapper.apply(this.value));
        }
    }

    OptionalString or(Supplier<String> supplier) {
        if (isPresent()) {
            return this;
        } else {
            return OptionalString.of(supplier.get());
        }
    }

    private boolean isPresent() {
        return isPresent;
    }

    String orElse(String other) {
        return isPresent ? value : other;
    }

    public String getAsString() {
        if (!isPresent) {
            throw new NoSuchElementException("No value present");
        }
        return value;
    }

}