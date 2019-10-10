package com.stackoverflow.nullpointer.expression;

import java.util.Scanner;

public class SwitchExpressionExtendedBreak {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Day day = Day.valueOf(scanner.next());
        /*
         * After JEP-325
         */
        int j = switch (day) {
            case MONDAY -> 0 ;
            case TUESDAY -> 1 ;
            default ->{
                int k = day.toString().length();
                int result = f(k);
                break result;
            }
        } ;
        System.out.println("j = " + j);

    }

    private static int f(int k) {
        return 100;
    }
}