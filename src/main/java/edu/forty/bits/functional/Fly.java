package edu.forty.bits.functional;

/**
 * Default methods get inherited automatically
 * We can override a default method
 * Method in class hierarchy rules
 * If there is a collision - hierarchy needs to be resolved
 */

interface Fly {
    default void takeOff() {
        System.out.println("Fly :: takeOff");
    }

    default void turn() {
        System.out.println("Fly :: turn");
    }

    default void cruise() {
        System.out.println("Fly :: cruise");
    }

    default void land() {
        System.out.println("Fly :: land");
    }
}