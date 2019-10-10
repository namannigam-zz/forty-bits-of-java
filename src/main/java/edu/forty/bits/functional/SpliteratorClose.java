package edu.forty.bits.functional;

import java.util.Spliterator;
import java.util.stream.Stream;

public class SpliteratorClose {

    public static void main(String[] args) {

        Stream<String> stream = Stream.of("a", "b", "c");
        Spliterator<String> spliterator = stream.spliterator();
        // Some low lever operation with the spliterator
        stream.close(); // do we need to close?

        Stream<String> stream2 = Stream.of("a", "b", "c").limit(2);
        Spliterator<String> spliterator2 = stream2.spliterator();
        stream.close();
        // Some low lever operation with the spliterator
    }
}