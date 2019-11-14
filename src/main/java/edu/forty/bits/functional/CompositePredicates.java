package edu.forty.bits.functional;

import edu.forty.bits.__Trial__;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CompositePredicates {

  public static void main(String[] args) {
    Stream<Integer> stream = Stream.of(5, 7, 9, 11, 13, 14, 21, 28, 35, 42, 49, 56, 63, 70, 71);
    IntPredicate p0 = n -> n > 10;
    IntPredicate p1 = n -> n % 2 != 0;
    IntPredicate p2 = CompositePredicates::isPrime;
    System.out.println(matchAll(stream, p0, p1, p2));
    // should get [11, 13, 71]
  }

  private static boolean isPrime(Integer n) {
    return IntStream.range(2, n) // note  division by zero possible in your attempt
        .noneMatch(i -> n % i == 0);
  }

  private static List<Integer> matchAll(Stream<Integer> input, IntPredicate... conditions) {
    IntPredicate compositePredicate =
        Arrays.stream(conditions).reduce(IntPredicate::and).orElse(p -> true);
    return input.mapToInt(i -> i).filter(compositePredicate).boxed().collect(Collectors.toList());
  }
}