package com.stackoverflow.nullpointer.lang;

import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class PatternPredicate {

    public static void main(String[] args) {
        var progLangs = List.of("c#", "java", "python", "scala");
        var p = Pattern.compile("[a-z]{4}");

        for (String lang : progLangs) {
            if (p.matcher(lang).matches()) {
                System.out.println(lang);
            }
        }

        progLangs.stream()
                .filter(s -> p.matcher(s).matches())
                .forEach(System.out::println);

        progLangs.stream().filter(Predicate.not(p.asMatchPredicate())).forEach(System.out::println);

    }
}