package com.stackoverflow.nullpointer.inheritence;

public abstract class Animal {
    private String kind, appearance;

    Animal(String Kind, String Appearance) {
        this.kind = Kind;
        this.appearance = Appearance;
    }

    public abstract void eat();

    public abstract void move();

    @Override
    public String toString() {
        return "(" + kind + "," + appearance + ")";
    }
}