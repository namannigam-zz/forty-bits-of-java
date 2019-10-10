package edu.forty.bits.function;

@FunctionalInterface
public interface Sayable {
    void say(String msg); //abstract method

    //It can contain any number of Object class methods.
    int hashCode();

    String toString();

    boolean equals(Object obj);
}