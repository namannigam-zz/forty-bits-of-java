package com.stackoverflow.nullpointer.reflect;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class StringConcatenationInJv9 {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException {
        MethodHandle concatHandle = MethodHandles.publicLookup()
                .findVirtual(String.class, "concat", MethodType.methodType(String.class, String.class));
        concatHandle = concatHandle.bindTo("Hello, ");
    }
}