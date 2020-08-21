package edu.forty.bits.utilities;

import java.util.Optional;
import java.util.OptionalLong;
import java.util.stream.LongStream;

public class LongOptional {

    public static void main(String[] args) {
        final OptionalLong optionalLong = OptionalLong.of(5);
        Optional<Long> opt = Optional.of(optionalLong).flatMap(LongOptional::optionalOfLong);
    }

    private static Optional<Long> optionalOfLong(OptionalLong optionalLong) {
        if (optionalLong.isPresent()) {
            return Optional.of(optionalLong.getAsLong());
        } else {
            return Optional.empty();
        }
    }

    public static LongStream stream(OptionalLong optional) {
        return optional.isPresent() ? LongStream.of(optional.getAsLong()) : LongStream.empty();
    }
}