package com.stackoverflow.nullpointer.functional;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SupplierInStreams {


    public static void main(String[] args) {
        Supplier<List<String>> expensiveListSupplier = getExpensiveList();
        getList().stream()
                .filter(s -> expensiveListSupplier.get().contains(s))
                .forEach(System.out::println);
    }

//    public static void convertNumbersToName(String[] args) {
//        Supplier<List<String>> expensiveListSupplierInStreams = getExpensiveList();
//        List<String> list = getList();
//        if (!list.isEmpty()) {
//            List<String> expensiveList = expensiveListSupplierInStreams.get();
//            list.stream()
//                    .filter(expensiveList::contains)
//                    .forEach(System.out::println);
//        }
//    }

    private static Supplier<List<String>> getExpensiveList() {
        return () -> Stream
                .of("1", "2", "3")
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    private static List<String> getList() {
        return Stream.of("2", "3")
                .collect(Collectors.toList());
    }
}