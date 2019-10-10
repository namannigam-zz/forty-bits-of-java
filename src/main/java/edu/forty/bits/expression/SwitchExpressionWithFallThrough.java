package com.stackoverflow.nullpointer.expression;

import java.util.Scanner;

public class SwitchExpressionWithFallThrough {

    public static void main(String[] args) {
        String s = new Scanner(System.in).next();

        /*
         * After JEP-325
         */
        int result = switch (s) {
            case "Foo":
                break 1;
            case "Bar":
                break 2;
            default:
                System.out.println("Neither Foo nor Bar, hmmm...");
                break 0;
        };
    }
}
