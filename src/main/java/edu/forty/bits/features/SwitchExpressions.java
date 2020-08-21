
package edu.forty.bits.features;

import java.time.Instant;
import java.util.Date;
import java.util.Scanner;
import java.util.function.Function;

/**
 * https://openjdk.java.net/jeps/325
 * https://openjdk.java.net/jeps/354
 * https://openjdk.java.net/jeps/361
 */
public class SwitchExpressions {
    private enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    public static void main(String[] args) {
        sample();
        localVariableTypeInference();
        Integer integer = polyExpression(Day.MONDAY, 1, 2, 3);
        System.out.println(integer);
        Boolean bool = polyExpression(Day.MONDAY, true, false, true);
        System.out.println(bool);
    }


    // minimal example
    private static void sample() {
        Scanner scanner = new Scanner(System.in);
        Day day = Day.valueOf(scanner.next());
        switch (day) {
            case MONDAY, TUESDAY -> System.out.println("Back to work.");
            case WEDNESDAY -> System.out.println("Wait for the week to end...");
            case THURSDAY, FRIDAY -> System.out.println("Plan for the weekend?");
            case SATURDAY, SUNDAY -> System.out.println("Enjoy the holiday!");
        }
    }

    // switch expression and local variable type inference
    private static void localVariableTypeInference() {
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
    //    A switch expression is a poly expression; if the target type is known, this type is pushed down into each arm.
    //    The type of a switch expression is its target type, if known; if not, a standalone type is
    //    computed by combining the types of each case arm.

    // switch expression as poly expression
    private static <T> T polyExpression(Day day, T e1, T e2, T e3) {
        return switch (day) {
            case MONDAY -> e1;
            case TUESDAY -> e2;
            default -> e3;
        };
    }

    // extended break with switch expression
    private static void extendedBreak() {
        Scanner scanner = new Scanner(System.in);
        Day day = Day.valueOf(scanner.next());
        int j = switch (day) {
            case MONDAY -> 0;
            case TUESDAY -> 1;
            default -> {
                int k = day.toString().length();
                yield f(k);
            }
        };
        System.out.println("j = " + j);
    }

    private static int f(int k) {
        return k * 100;
    }

    // reuse the local variables
    private static void localVariableReuse(Day day) {
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

        // After JEP-325
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

    // branch the expressions as part of the lambda expression
    private void howMany(int k) {
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

    // expression restricts a jump during the switch cases
    private static void restrictJump() {
        //A further consequence is that the control statements, break, return and continue,
        // cannot jump through a switch expression, such as in the following:
        int e = new Scanner(System.in).nextInt();
        for (int i = 0; i < 100; ++i) {
            int k = switch (e) {
                case 0:
                    yield 1;
                case 1:
                    yield 2;
                default:
//                     continue;
//              ERROR! Illegal jump through a switch
                    yield 0;
            };
        }
    }

    // A switch expression must complete or throw an exception.
    // The fallthrough cases are avoided with the expressions

    // we may expand switch to support switching on primitive types (and their box types)
    // that have previously been disallowed such as float, double, and long.
    private static void expressionsWithPrimitives() {
    }
}