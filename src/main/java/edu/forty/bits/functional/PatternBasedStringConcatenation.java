package edu.forty.bits.functional;

import java.util.function.BiConsumer;
import java.util.function.Function;

public class PatternBasedStringConcatenation {

    public static void main(String[] args) {
        Function<String, String> con = Util::concat;
        BiConsumer<String, String> biConsumer = (x, y) -> System.out.println(x + y);
        biConsumer.accept(con.apply("x"), con.apply("y"));
    }

    static class Util {
        static String concat(String x) {
            return "con".concat(x);

        }
    }
}