package edu.forty.bits.expression;

import java.time.Instant;
import java.util.Date;
import java.util.Scanner;

public class SwitchExpressionLocalVariable {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Day day = Day.valueOf(scanner.next());

        /*
         * Before JEP-325
         */
        switch (day) {
            case MONDAY:
            case TUESDAY:
                var temp = "";
                break;
            case WEDNESDAY:
            case THURSDAY:
                var temp2 = 1;     // Why can't I call this temp?
                break;
            default:
                var temp3 = 0.04;     // Why can't I call this temp?
        }


        /*
         * After JEP-325
         */
        switch (day) {
            case MONDAY, TUESDAY -> {
                var temp = "mon-tue";
                System.out.println(temp);
            }
            case WEDNESDAY, THURSDAY -> {
                var temp = Date.from(Instant.now());
                System.out.println(temp);
            }
            default -> {
                var temp = 0.04;
                System.out.println(temp);
            }
        }
    }
}