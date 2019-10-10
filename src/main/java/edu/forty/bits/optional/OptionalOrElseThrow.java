package edu.forty.bits.optional;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

public class OptionalOrElseThrow {

    public static void main(String[] args) {
        Optional<Integer> anyOddInStream = Stream.of(2, 4, 6, 8).filter(x -> x % 2 == 1).findAny();
        Integer previous = anyOddInStream.get();
        Integer previousAlt = anyOddInStream.orElseThrow(() -> new NoSuchElementException("No value present"));
        var current = anyOddInStream.orElseThrow();

        System.out.println(previous);
        System.out.println(previousAlt);
        System.out.println(current);

        var optional2 = Stream.of(1, 2, 3, 4).findAny();
        System.out.println(anyOddInStream.or(() -> optional2).orElseThrow());
    }
}