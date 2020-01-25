package edu.forty.bits.records;

public class Singleton {

    public static Singleton getInstance() {
        record Holder() {
            static final Singleton INSTANCE = new Singleton();
        }
        return Holder.INSTANCE;
    }

    public Singleton leak() {
        // try using Holder here
        System.out.println("I wanted to leak information!");
        return Singleton.getInstance();
    }
}