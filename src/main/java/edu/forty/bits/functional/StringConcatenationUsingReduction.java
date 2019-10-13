package edu.forty.bits.functional;

import java.util.List;
import java.util.stream.Collectors;

public class StringConcatenationUsingReduction {

    /**
     * Perhaps surprisingly, need not be commutative, though many operators commonly used for reduction,
     * such as as plus and max, are. An example of a binary operator that’s associative but not commutative
     * is string concatenation.
     */
    public static void main(String[] args) {
        List<String> strings = List.of("An", "example", "of", "a", "binary", "operator");
        // this will have O(n^2) runtime
        System.out.println(strings.stream().reduce(" ", String::concat));
        // this will have O(n) runtime
        System.out.println(strings.stream().collect(() -> new StringBuilder(" "), StringBuilder::append,
                StringBuilder::append).toString());


        /*
         * If the provided binary operator isn’t associative, or the provided identity value isn’t actually an identity
         * for the binary operator, then when the operation is executed in parallel,
         * the result might be incorrect, and different executions on the same data set might produce different results.
         */
        System.out.println(strings.stream().parallel().reduce(" ", String::concat));


        /*
         * The key difference is that, with the forEach() version, multiple threads are trying to access
         * a single result container simultaneously, whereas with parallel collect(),
         * each thread has its own local result container, the results of which are merged afterward.
         */
        System.out.println(strings.stream().collect(() -> new StringBuilder(" "), StringBuilder::append,
                StringBuilder::append).toString());

        /*
         * Analogous operation for reduction in parallel
         */
        System.out.println(strings.stream().parallel().collect(Collectors.joining(" ")));
    }
}