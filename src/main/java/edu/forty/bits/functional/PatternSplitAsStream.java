package edu.forty.bits.functional;

import java.util.Comparator;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class PatternSplitAsStream {

    public static void main(String[] args) {

        String starWars = "Luke Darthor Obimain QuiGoin Palpatine";
        Function<String, Stream<String>> lineSplitter = l -> Pattern.compile(" ").splitAsStream(l);

        Stream.of(starWars)
                .flatMap(lineSplitter)
                .sorted((Comparator.reverseOrder()))
                .forEachOrdered(System.out::println);
    }
}