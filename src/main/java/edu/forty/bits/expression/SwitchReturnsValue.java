package com.stackoverflow.nullpointer.expression;

import java.util.Scanner;

public class SwitchReturnsValue {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Day day = Day.valueOf(scanner.next());

        /*
         * Before JEP-325
         */
        int numLetters;
        switch (day) {
            case MONDAY:
            case FRIDAY:
            case SUNDAY:
                numLetters = 6;
                break;
            case TUESDAY:
                numLetters = 7;
                break;
            case THURSDAY:
            case SATURDAY:
                numLetters = 8;
                break;
            case WEDNESDAY:
                numLetters = 9;
                break;
            default:
                throw new IllegalStateException("Wat: " + day);
        }


        /*
         * After JEP-325
         */
        int numLetter = switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> 6;
            case TUESDAY                -> 7;
            case THURSDAY, SATURDAY     -> 8;
            case WEDNESDAY              -> 9;
        };
    }
}