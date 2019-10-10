package com.stackoverflow.nullpointer.expression;

import java.util.Scanner;

public class SwitchExpressionMustComplete {

    public static void main(String[] args) {
//        Furthermore, a switch com.stackoverflow.nullpointer.expression must complete normally with a value, or throw an exception.
        Scanner scanner = new Scanner(System.in);
        Day day = Day.valueOf(scanner.next());

//        int i = switch (day) {
//            case MONDAY -> {
//                System.out.println("Monday");
//                // ERROR! Block doesn't contain a break with value
//            }
//            default -> 1;
//        };
//        System.out.println("i=" + i);

//        System.out.println(hold("bug"));


        int i = switch (day) {
            case MONDAY,TUESDAY, WEDNESDAY:
                break 0;
            default:
                System.out.println("Second half of the week");
                // ERROR! Group doesn't contain a break with value
                                break 1;
        } ;



    }

//    static String hold(String item) {
//        return switch(item) {
//            case String s -> { System.out.println(s); }
//            default -> "temp";
//        };
//    }
}