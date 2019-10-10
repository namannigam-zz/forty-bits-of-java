package edu.forty.bits.functional;

interface Sail {
    default public void cruise() {
        System.out.println("Sail :: cruise");
    }
}
