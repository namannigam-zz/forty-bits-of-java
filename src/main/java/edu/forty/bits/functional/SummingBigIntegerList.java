package edu.forty.bits.functional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SummingBigIntegerList {

    public static void main(String[] args) {
        Map<String, List<BigDecimal>> input = new HashMap<>();

        Map<String, BigDecimal> result = new HashMap<>();

        result = input.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().stream().reduce(BigDecimal.ZERO, BigDecimal::add)));

//        result = input.entrySet().stream()
//                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add)));

        result = input.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        x -> x.getValue().stream().reduce(BigDecimal::add).orElse(BigDecimal.ZERO)

                ));
    }
}