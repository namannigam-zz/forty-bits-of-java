package edu.forty.bits;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public  class Pair<T> {
    private T first;
    private T second;

    public static <T> Pair<T> of(T first, T second) {
        return new Pair<>(first, second);
    }
}