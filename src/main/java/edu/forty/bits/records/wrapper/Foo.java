package edu.forty.bits.records.wrapper;

import java.util.Arrays;

record Foo(int[]ints) {

    @Override
    public String toString() {
        return "Foo{" +
                "ints=" + Arrays.toString(ints) +
                '}';
    }
}
