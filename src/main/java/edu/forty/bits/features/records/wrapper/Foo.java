package edu.forty.bits.features.records.wrapper;

import java.util.Arrays;

record Foo(int[]ints) {

    @Override
    public String toString() {
        return "Foo{" +
                "ints=" + Arrays.toString(ints) +
                '}';
    }
}
