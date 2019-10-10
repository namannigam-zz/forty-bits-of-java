package edu.forty.bits.expression;

import java.util.Scanner;

public class SwitchExpressions {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Day day = Day.valueOf(scanner.next());
        // JEP-325
        switch (day) {
            case MONDAY, TUESDAY -> System.out.println("Back to work.") ;
            case WEDNESDAY -> System.out.println("Wait for the week to end...") ;
            case THURSDAY,FRIDAY -> System.out.println("Plan for the weekend?");
            case SATURDAY, SUNDAY -> System.out.println("Enjoy the holiday!");
        }
    }

    public enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }
}