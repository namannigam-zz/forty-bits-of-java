package edu.forty.bits.jdk09.challenges;

import java.util.List;

public class Challenge12 {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 6, 7, 90, 100);

        list.stream().takeWhile(e -> e < 100).dropWhile(f -> f < 50).forEach(System.out::println);
    }
}