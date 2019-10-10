package com.stackoverflow.nullpointer.date;

public enum  SimpleEnum {

    ONE,
    TWO;

    static {
        System.out.println("hey there, execute me please...");
    }

    public static SimpleEnum advancedValueOf(String s) {
        return ONE;//This method would find enum by its parameters
    }

}