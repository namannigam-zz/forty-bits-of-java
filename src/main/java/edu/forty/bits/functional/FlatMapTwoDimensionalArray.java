package edu.forty.bits.functional;

import java.util.Arrays;
import java.util.stream.Stream;

public class FlatMapTwoDimensionalArray {

    public static void main(String[] args) {
        String[][] strArray = {{"Sample1", "Sample2"}, {"Sample3", "Sample4", "Sample5"}};
        new FlatMapTwoDimensionalArray().flatMapTwoDimensionalArray(strArray).forEach(System.out::println);
        int[][] intArr = {{1, 2, 3}, {4, 5, 6}};
        new FlatMapTwoDimensionalArray().flatMapTwoDimensionalArray(intArr).forEach(System.out::println);
    }

    <T> Stream<T> flatMapTwoDimensionalArray(T[][] array) {
        return Arrays.stream(array).flatMap(Arrays::stream);
    }

    Stream<Integer> flatMapTwoDimensionalArray(int[][] array) {
        return Arrays.stream(array).flatMap(arr -> Arrays.stream(arr).boxed());
    }

    Stream<Double> flatMapTwoDimensionalArray(double[][] array) {
        return Arrays.stream(array).flatMap(arr -> Arrays.stream(arr).boxed());
    }

    Stream<Long> flatMapTwoDimensionalArray(long[][] array) {
        return Arrays.stream(array).flatMap(arr -> Arrays.stream(arr).boxed());
    }
}