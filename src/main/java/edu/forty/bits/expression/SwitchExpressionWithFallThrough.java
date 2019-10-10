package edu.forty.bits.expression;

import java.util.Scanner;

public class SwitchExpressionWithFallThrough {

    public static void main(String[] args) {
        String s = new Scanner(System.in).next();

        /*
         * After JEP-325
         */
        int result = switch (s) {
            case "Foo":
                yield 1;
            case "Bar":
                yield 2;
            default:
                System.out.println("Neither Foo nor Bar, hmmm...");
                yield 0;
        };
    }
}