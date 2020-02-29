package edu.forty.bits.functional;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

// https://stackoverflow.com/questions/60443274
public class SearchingWordsInComments {

    public static void main(String[] args) {

        searchWordsInComments(Arrays.asList("Oranges", "Figs", "Mangoes", "Apples"),
                Arrays.asList("Apples are better than Oranges", "I love Mangoes and Oranges",
                        "I don't know like Figs. Mangoes are my favorites", "I love Mangoes and Apples"));

        searchWordsInCommentsByHolger(Arrays.asList("Oranges", "Figs", "Mangoes", "Apples"),
                Arrays.asList("Apples are better than Oranges", "I love Mangoes and Oranges",
                        "I don't know like Figs. Mangoes are my favorites", "I love Mangoes and Apples"));
    }

    static void searchWordsInComments(List<String> elements, List<String> listOfComments) {
        Set<String> lowerCaseSet = elements.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toSet());

        Map<String, Long> output = listOfComments.stream()
                .flatMap(e -> Arrays.stream(e.replace(".", "")
                        .split(" "))
                        .map(String::toLowerCase))
                .filter(lowerCaseSet::contains)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry<String, Long>::getValue).reversed().thenComparing(Map.Entry::getKey))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));

        System.out.println(output);

        Function<String, Map.Entry<String, Long>> function = f -> Map.entry(f, listOfComments.stream()
                .filter(e -> e.toLowerCase().contains(f.toLowerCase())).count());

        elements.stream()
                .map(function)
                .sorted(Comparator.comparing(Map.Entry<String, Long>::getValue)
                        .reversed().thenComparing(Map.Entry::getKey))
                .forEach(System.out::println);
    }

    static void searchWordsInCommentsByHolger(List<String> elements, List<String> listOfComments) {
        Map<String, Predicate<String>> filters = elements.stream()
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .map(s -> Pattern.compile(s, Pattern.LITERAL | Pattern.CASE_INSENSITIVE))
                .collect(Collectors.toMap(Pattern::pattern, Pattern::asPredicate,
                        (a, b) -> {
                            throw new AssertionError("duplicates");
                        }, LinkedHashMap::new));

        filters.entrySet().stream()
                .map(e -> Map.entry(e.getKey(), listOfComments.stream().filter(e.getValue()).count()))
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(e -> System.out.printf("%-7s%3d%n", e.getKey(), e.getValue()));
    }
}