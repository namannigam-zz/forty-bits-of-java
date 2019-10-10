package com.stackoverflow.nullpointer.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class BiConsumerForStringAndFunction {

    public static void main(String[] args) {
        ClassA instance = new ClassA();
        getData().stream().map(method -> method.apply(instance)).forEach(System.out::println);

        BiConsumer<ClassA, String> bc = ClassA::printName;
    }

    private static List<Function<ClassA, String>> getData() {
        return new ArrayList<>();
    }

    private static class ClassA {
        void printName(String s) {
            System.out.println(s);
        }
    }
}