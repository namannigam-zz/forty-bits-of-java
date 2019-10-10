package edu.forty.bits.jdk09.challenges;

import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Challenge9 {

    public static void main(String[] args) {

        String starWars = "Luke Darthor Obimain QuiGoin Palpatine";
        Function<String, Stream<String>> lineSplitter = l -> Pattern.compile(" ").splitAsStream(l);

        Stream.of(starWars).flatMap(lineSplitter).sorted(((o1, o2) -> o2.compareTo(o1)))
                .forEachOrdered(System.out::println);

    }
}