package edu.forty.bits.inheritence;

public abstract class Bird extends Animal {//SubClass of superClass Animal

    Bird(String kind, String appearance) {
        super(kind, appearance);
    }

    @Override
    public void eat() {
        System.out.println("Eats seeds and insects");
    }

    @Override
    public void move() {
        System.out.println("Flies throught the air");
    }

}