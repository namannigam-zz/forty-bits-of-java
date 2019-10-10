package edu.forty.bits.functional;

import java.util.stream.Stream;

public class StreamOfNullable {

    public static void main(String[] args) {
        long one = Stream.ofNullable("42").count();
        long zero = Stream.ofNullable(null).count();
        System.out.println(one);
        System.out.println(zero);
    }
}