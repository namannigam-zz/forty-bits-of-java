package com.stackoverflow.nullpointer.interfaces;

public interface Another<T> {

    default T someMethod() {
        return null;
    }
}
