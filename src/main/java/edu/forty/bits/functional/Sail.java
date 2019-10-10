package com.stackoverflow.nullpointer.functional;

interface Sail {
    default public void cruise() {
        System.out.println("Sail :: cruise");
    }
}
