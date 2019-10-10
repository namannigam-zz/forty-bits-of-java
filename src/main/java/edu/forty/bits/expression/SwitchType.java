package com.stackoverflow.nullpointer.expression;

public class SwitchType {

    public static void main(String[] args) {
        var y = switch (0) {
            case 0 -> '0';
            case 1 -> 0.0F;
            case 2 -> 2L;
            case 3 -> true;
            default -> 4;
        };
        System.out.println(y);
        System.out.println(((Object) y).getClass().getName());
    }
}
