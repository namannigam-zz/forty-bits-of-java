package com.stackoverflow.nullpointer.inheritence;

public class UseHierarchy {

    public static void main(String[] args) {
        String kind = "kind";
        String appearance = "appearance";
        Animal animal = new AmericanRobin(kind,appearance);

        System.out.println(animal.toString());
        Bird bird = new AmericanRobin(kind,appearance);
        System.out.println(bird.toString());
        AmericanRobin americanRobin = new AmericanRobin(kind,appearance);
        System.out.println(americanRobin.toString());
    }
}
