package edu.forty.bits.functional;

import java.util.function.Function;

public class CompositeFunctions {

    public static void main(String[] args) {
        Function<Integer, Integer> add = x -> x + 2;
        Function<Integer, Integer> sub = x -> x - 2;
        Function<Integer, Integer> div = x -> x / 2;
        Function<Integer, Integer> mul = x -> x * 2;
        Function<Integer, Integer> function = add.andThen(sub).andThen(div).andThen(mul);
        System.out.println(function.apply(2));
    }
}