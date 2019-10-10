package edu.forty.bits.optional;

@FunctionalInterface
public interface StringSupplier {


    /**
     * Gets a result.
     *
     * @return a result
     */
    String getAsString();
}