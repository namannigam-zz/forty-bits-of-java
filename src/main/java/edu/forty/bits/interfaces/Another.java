package edu.forty.bits.interfaces;

public interface Another<T> {

    default T someMethod() {
        return null;
    }
}
