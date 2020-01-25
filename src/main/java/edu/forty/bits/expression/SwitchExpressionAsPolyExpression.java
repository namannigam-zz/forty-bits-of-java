package edu.forty.bits.expression;

public class SwitchExpressionAsPolyExpression {

    /*
     * After JEP-325
     */
    private static <T> T polyExpression(Day day, T e1, T e2, T e3) {
        return switch (day) {
            case MONDAY -> e1;
            case TUESDAY -> e2;
            default -> e3;
        };
    }
}