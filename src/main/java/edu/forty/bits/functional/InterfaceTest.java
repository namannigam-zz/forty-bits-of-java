package edu.forty.bits.functional;

public interface InterfaceTest {

    void main();

    default void m1() {
        System.out.println("this is test interface");
    }
}