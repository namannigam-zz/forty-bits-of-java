package com.stackoverflow.nullpointer.expression;

import java.util.Scanner;

public class SwitchExpressionAsPolyExpression {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Day day = Day.valueOf(scanner.next().toUpperCase());
        System.out.println(String.valueOf(polyExpression(day)));
    }

    private static <T> T polyExpression(Day day) {
        T result = null;
        T e1 = null, e2 = null, e3 = null;
        /*
         * After JEP-325
         */
        result = switch (day) {
            case MONDAY -> e1
            ;
            case TUESDAY -> e2
            ;
            default -> e3;
        };
        return result;
    }
}