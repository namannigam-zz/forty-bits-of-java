package edu.forty.bits.functional;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// https://stackoverflow.com/questions/58782150/removing-overloaded-method-in-java
public class OverloadUsingUnaryOperator {

  public static <T, G> List<G> toListOfNewType(
      List<T> inputList, Function<T, G> mapperFunction, Comparator<? super G> comparator) {
    return toListOfNewTypeImpl(inputList, mapperFunction, s -> s.sorted(comparator));
  }

  public static <T, G> List<G> toListOfNewType(List<T> inputList, Function<T, G> mapperFunction) {
    return toListOfNewTypeImpl(inputList, mapperFunction, UnaryOperator.identity());
  }

  private static <T, G> List<G> toListOfNewTypeImpl(
      List<T> inputList, Function<T, G> mapperFunction, UnaryOperator<Stream<G>> lastOp) {
    return lastOp.apply(inputList.stream().map(mapperFunction)).collect(Collectors.toList());
  }


  public static <T, G> List<G> toListOfNewTypeIdentityComparator(
      List<T> inputList, Function<T, G> mapperFunction) {
    return toListOfNewType(inputList, mapperFunction, (a, b) -> 0);
  }
}