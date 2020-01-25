
package edu.forty.bits.expression;

import java.util.Scanner;

public class SwitchExpressionAndLocalVariableType {

    public static void main(String[] args) {
        int value = new Scanner(System.in).nextInt();
        var y = switch (value) {
            case 0 -> '0';
            case 1 -> 0.0F;
            case 2 -> 2L;
            case 3 -> true;
            default -> 4;
        };
        System.out.println(y);
        System.out.println(y.getClass().getName());
    }
}