package edu.forty.bits.expression;

import java.util.Scanner;

public class SwitchExpressionsFallThrough {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        /*
         * Before JEP-325
         */
//        switch (value) {
//            case 1:
//                System.out.println("one");
//            case 2:
//                System.out.println("two");
//            default:
//                System.out.println("many");
//        }

        /*
         * After JEP-325
         */
        switch (value) {
            case 1 -> System.out.println("one");
            case 2 -> System.out.println("two");
            default -> System.out.println("many");
        }

        String s  = "lk";
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