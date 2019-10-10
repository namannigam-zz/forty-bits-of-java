package edu.forty.bits.functional;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class HashMapUsingStringAndSubstrings {

    public static void main(String[] args) {
        String lines ="t12345-g1234-o1234";
        Map<String, String> collect = Arrays.stream(lines.split(";")).collect(Collectors.toMap(s -> s.substring(0, 1), s -> s.substring(1)));

        System.out.println();
    }
}