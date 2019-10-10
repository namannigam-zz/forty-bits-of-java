package edu.forty.bits.functional;

interface FastFly extends Fly {
    default void takeOff() {
        System.out.println("FastFly :: takeOff");  // We can override a default method
    }
}