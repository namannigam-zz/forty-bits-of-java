package edu.forty.bits.reflect;

public interface Calculator {
    default int methodA(int a, int b) {
        return a - b;
    }
}
