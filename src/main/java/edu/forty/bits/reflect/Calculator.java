package com.stackoverflow.nullpointer.reflection;

public interface Calculator {
    default int methodA(int a, int b) {
        return a - b;
    }
}
