package com.stackoverflow.nullpointer.jdk09.challenges;

import java.util.function.Function;

public class Challenge15 {

    public static void main(String[] args) {
        Function<Integer, Integer> add = x -> x + 2;
        Function<Integer, Integer> sub = x -> x - 2;
        Function<Integer, Integer> div = x -> x / 2;
        Function<Integer, Integer> mul = x -> x * 2;


        Function<Integer, Integer> function = add
                .andThen(sub).andThen(div);

        System.out.println(function.apply(2));

    }
}