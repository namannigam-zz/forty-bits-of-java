package edu.forty.bits.functional;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SummingRowsAndColumns {

    public static double[] sumUpColumns(double[][] x) {
        return IntStream.range(0, Stream.of(x).mapToInt(a -> a.length).max().orElse(0))
                .mapToDouble(i -> Arrays.stream(x)
                        .mapToDouble(item -> i < item.length ? item[i] : 0.0)
                        .sum())
                .toArray();
    }

    public static double[] sumUpRows(double[][] x) {
        return Stream.of(x)
                .mapToDouble((double[] row) -> DoubleStream.of(row).sum())
                .toArray();
    }
}
