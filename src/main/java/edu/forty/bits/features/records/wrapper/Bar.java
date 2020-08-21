package edu.forty.bits.features.records.wrapper;

import java.util.Arrays;

class Bar{
    int[] arr;

    public Bar(int[] arr) {
        this.arr = arr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bar bar = (Bar) o;

        return Arrays.equals(arr, bar.arr);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(arr);
    }

    @Override
    public String toString() {
        return "Bar{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }
}
