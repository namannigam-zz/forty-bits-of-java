package edu.forty.bits.utilities;

import java.io.File;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

public class OptionalOrElse {

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

    boolean isValid(File optFile) {
        Optional.ofNullable(optFile).ifPresentOrElse(this::doWork, this::doNothing);
        return Optional.ofNullable(optFile).filter(this::isZeroLine).isPresent();
    }

    private boolean isZeroLine(File f) {
        return f.canRead();
    }

    private void doWork(File f) {
    }

    private void doNothing() {
    }
}