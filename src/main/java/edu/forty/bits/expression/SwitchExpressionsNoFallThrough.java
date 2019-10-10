package com.stackoverflow.nullpointer.expression;

import java.util.Scanner;

public class SwitchExpressionsNoFallThrough {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
//        /*
//         * Before JEP-325
//         */
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
            case 1 ->System.out.println("one");
            case 2 ->System.out.println("two");
            default ->System.out.println("many");
        }
    }
}