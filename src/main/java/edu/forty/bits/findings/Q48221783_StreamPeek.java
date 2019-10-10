package com.stackoverflow.nullpointer.findings;

import java.util.Arrays;
import java.util.List;

/**
 * @see <href>https://stackoverflow.com/questions/48221783</href>
 */
public class Q48221783_StreamPeek {

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1, 2, 3);
        values.stream()
                .map(n -> n * 2)
                .peek(System.out::print)
                .count();
    }
}