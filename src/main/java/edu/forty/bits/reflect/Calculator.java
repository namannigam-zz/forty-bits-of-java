package edu.forty.bits.reflection;

public interface Calculator {
    default int methodA(int a, int b) {
        return a - b;
    }
}
