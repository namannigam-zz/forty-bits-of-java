package com.stackoverflow.nullpointer.expression;

public class RephraseInitializingVariable {

    public static void main(String[] args) {
        int key = 2;
        int value = switch (key) {
            case 1 ->  1;
            case 2 -> 2;
            default -> {break 0;}
        };
        System.out.println("value = " + value);
    }
}
