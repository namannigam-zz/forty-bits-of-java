package com.stackoverflow.nullpointer.expression;

public class GenericSwitchExpression {

    static <T> T genericSwitch(boolean ternaryBool) {
        return switch (ternaryBool) {
            case Boolean.TRUE -> Boolean.TRUE;
            case Boolean.FALSE -> Integer.valueOf(0);
            default -> throw new IllegalArgumentException("Seriously?!");
        };
    }
}