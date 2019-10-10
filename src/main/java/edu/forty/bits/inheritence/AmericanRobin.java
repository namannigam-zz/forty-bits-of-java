package com.stackoverflow.nullpointer.inheritence;

public class AmericanRobin extends Bird {

    String fly;

    public String getFly() {
        return fly;
    }

    public void setFly(String fly) {
        this.fly = fly;
    }

    AmericanRobin(String kind, String appearance) {
        super(kind, appearance);
    }

}