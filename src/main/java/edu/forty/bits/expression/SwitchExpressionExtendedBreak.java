package edu.forty.bits.expression;

import java.util.Scanner;

public class SwitchExpressionExtendedBreak {


    /*
     * After JEP-325
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Day day = Day.valueOf(scanner.next());
        int j = switch (day) {
            case MONDAY -> 0;
            case TUESDAY -> 1;
            default -> {
                int k = day.toString().length();
                int result = f(k);
                yield result;
            }
        };
        System.out.println("j = " + j);

    }

    private static int f(int k) {
        return 100;
    }
}