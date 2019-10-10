package edu.forty.bits.functional;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SampleStream {

    public static void main(String[] args) {
        IntStream.range(0, 5).forEach(i -> createFile("", "test.txt"));
        Stream.iterate("text.txt", x -> "test.txt")
                .limit(5)
                .forEach(x -> createFile("", x));
    }

    public static void createFile(String directoryPath, String fileName) {
    }
}