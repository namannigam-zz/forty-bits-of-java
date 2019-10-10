package com.stackoverflow.nullpointer.optional;

@FunctionalInterface
public interface StringSupplier {


    /**
     * Gets a result.
     *
     * @return a result
     */
    String getAsString();
}