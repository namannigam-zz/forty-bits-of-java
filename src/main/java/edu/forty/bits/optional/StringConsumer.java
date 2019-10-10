package edu.forty.bits.optional;

import java.util.Objects;

@FunctionalInterface
public interface StringConsumer {

    /**
     * Performs this operation on the given argument.
     *
     * @param value the input argument
     */
    void accept(String value);


    default StringConsumer andThen(StringConsumer after) {
        Objects.requireNonNull(after);
        return (String t) -> {
            accept(t);
            after.accept(t);
        };
    }

}