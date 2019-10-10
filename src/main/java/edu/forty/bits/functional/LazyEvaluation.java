package com.stackoverflow.nullpointer.functional;

import java.util.Arrays;
import java.util.List;

class LazyEvaluation {
    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9, 10);

        // double of the first even number in the list
        int result = 0;
        for (int e : values) {
            if (e > 3 && e % 2 == 0) {
                result = e * 2;
                break;
            }
        }
        System.out.println(result);
        System.out.println(values.stream().filter(e -> e > 3).filter(e -> e % 2 == 0).map(e -> e * 2).findFirst()
                .orElse(0)); // substitute with default
        /**
         * terminal functions - e.g findFirst()
         * lazy evaluation  - efficient evaluation
         */
        System.out.println(values.stream().filter(LazyEvaluation::isGT3).filter(LazyEvaluation::isEven).map(
                LazyEvaluation::doubleIt).findFirst()
                .orElse(0)); // replacing with methods to verify the number of iterationss
    }

    public static boolean isEven(int number) {
        System.out.println("is even for number = [" + number + "]");
        return number % 2 == 0;
    }

    public static boolean isGT3(int number) {
        System.out.println("is greated than 3 for number = [" + number + "]");
        return number > 3;
    }

    public static int doubleIt(int number) {
        System.out.println("double it for number = [" + number + "]");
        return number % 2;
    }
}
