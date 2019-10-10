package edu.forty.bits.jdk09.challenges;

import java.util.Arrays;
import java.util.stream.Stream;

public class Challenge13 {

    public static void main(String[] args) {
        String[][] strArray = {{"Sample1", "Sample2"}, {"Sample3", "Sample4", "Sample5"}};

        Stream<String> stream = Arrays.stream(strArray).flatMap(Arrays::stream);
        stream.sorted().takeWhile(ele -> !ele.equalsIgnoreCase("Sample4"))
                .forEach(System.out::println);

    }
}