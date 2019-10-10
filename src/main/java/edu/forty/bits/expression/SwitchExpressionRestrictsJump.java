package edu.forty.bits.expression;

import java.util.Scanner;

public class SwitchExpressionRestrictsJump {
    private static final int MAX_VALUE = Integer.MAX_VALUE;

    public static void main(String[] args) {
        //A further consequence is that the control statements, break, return and continue, cannot jump through a switch com.stackoverflow.nullpointer.expression, such as in the following:

        int e = new Scanner(System.in).nextInt();
        for (int i = 0; i < MAX_VALUE; ++i) {
            int k = switch (e) {
                case 0:
                    yield 1;
                case 1:
                    yield 2;
                default:
//                     continue;
                    yield 0;
                    // ERROR! Illegal jump through a switch com.stackoverflow.nullpointer.expression
            };
        }
    }
}