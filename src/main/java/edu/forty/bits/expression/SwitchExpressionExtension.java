package edu.forty.bits.expression;

import java.util.function.Function;

public class SwitchExpressionExtension {

    public static void main(String[] args) {
        howMany(1);
        howMany(3);
    }

    static void howMany(int k) {
        switch (k) {
            case 1 -> System.out.println("one");
            case 2 -> System.out.println("two");
            default -> System.out.println("many");
        }
        System.out.println(fun.apply(k));
    }

    static Function<Integer, String> fun = val -> switch (val) {
        case 1 -> "one";
        case 2 -> "two";
        default -> "many";
    };

//    A switch expression is a poly expression; if the target type is known, this type is pushed down into each arm.
//    The type of a switch expression is its target type, if known; if not, a standalone type is
//    computed by combining the types of each case arm.

//    T result = switch (arg) {
//        case L1 -> e1;
//        case L2 -> e2;
//        default -> e3;
//    };
}