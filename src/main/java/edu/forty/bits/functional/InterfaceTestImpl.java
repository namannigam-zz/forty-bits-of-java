package com.stackoverflow.nullpointer.functional;

public class InterfaceTestImpl implements InterfaceTest {

    public void main() {
        m1();
    }


    public static void main(String[] args) {
        new InterfaceTestImpl().main();
    }
}