package edu.forty.bits.functional;

import java.util.Optional;
import java.util.stream.Stream;

public class StreamFromOptional {

    public static void main(String[] args) {

        Optional<Integer> a = Optional.empty();
        Optional<Integer> b = null;
        Optional<Integer> aOrB = a.or(() -> b);


        Optional<String> optional = null;
        if (optional != null) {
            // execute either println or ()
            optional.ifPresentOrElse(System.out::println, () -> {
                System.out.println("");
            });
        }

        // return either optional or supplier
        optional.or(StreamFromOptional::supplier);


        // stream of optional
        Stream<Optional<Integer>> so = Stream.empty();
        Stream<Integer> s = so.flatMap(Optional::stream);
        Optional<Stream<Integer>> os = Optional.of(s);
    }

    private static Optional<? extends String> supplier() {
        return Optional.of("");
    }
}