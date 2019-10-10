package com.stackoverflow.nullpointer.lang;

import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomisedMargin {

    private static final String MARKER = "| ";

    private static String stripMargin(String com.stackoverflow.nullpointer.string) {
        return string.lines().map(String::strip)
                .map(s -> s.startsWith(MARKER) ? s.substring(MARKER.length()) : s)
                .collect(Collectors.joining("\n", "", "\n"));
    }

    // temporary
    private static <T> T transform(String str, Function<String, T> function) {
        return function.apply(str);
    }

    public static void main(String[] args) {
        String stripped = `
                          | The content of
                          | the string
                      `;
        ;
        System.out.print(transform(stripped, CustomisedMargin::stripMargin));

        //    Output:
        //    The content of
        //    the com.stackoverflow.nullpointer.string
    }
}