package edu.forty.bits.utilities;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.invoke.StringConcatException;
import java.lang.invoke.StringConcatFactory;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CompactStrings {

    String field;

    public static void main(String[] args) {
        overviewCompactString();
        concatFactory();
        testStringCompaction();
    }

    private static void concatFactory() {
        try {
            StringConcatFactory.makeConcat(MethodHandles.lookup(), "abc", MethodType.methodType(String.class));
//            StringConcatFactory.makeConcat(MethodHandles.publicLookup(), "abc", MethodType.methodType(String.class)); // throws a StringConcatException
        } catch (StringConcatException e) {
            e.printStackTrace();
        }
    }

    private static void testStringCompaction() {
        String java9 = "MAJOR.MINOR";
        StackWalker stackWalker = StackWalker.getInstance(Set.of(StackWalker.Option.RETAIN_CLASS_REFERENCE));
        stackWalker.getCallerClass();
        System.out.println(Arrays.toString(stackWalker.getCallerClass().getDeclaredFields()));
    }

    public static void overviewCompactString() {
        long startTime = System.currentTimeMillis();
        List strings = IntStream.rangeClosed(1, 10000000).mapToObj(Integer::toString).collect(Collectors.toList());
        long totaltime = System.currentTimeMillis() - startTime;

        System.out.println("Generated String " + strings.size() + " strings in " + totaltime + " ms.");


        startTime = System.currentTimeMillis();
        String appended = (String) strings.stream().limit(100000).reduce("", (l, r) -> l.toString() + r.toString());

        totaltime = System.currentTimeMillis() - startTime;


        System.out.println("Created String of length " + appended.length() + " in " + totaltime + " ms.");
    }
}