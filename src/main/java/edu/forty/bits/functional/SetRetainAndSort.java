package edu.forty.bits.functional;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SetRetainAndSort {

    public static List<SearchResult> some(String[] args) {
        Set<List<SearchResult>> searchResults = new HashSet<>();


//        return searchResults.stream()
//                .reduce((sr1, sr2) -> {
//                    sr1.retainAll(sr2);
//                    return sr1;
//                })
//                .get().stream()
//                .sorted(Comparator.comparing(SearchResult::getDocNo))
//                .collect(Collectors.toList());

        return searchResults.stream()
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() > 1)
                .map(Map.Entry::getKey)
                .sorted(Comparator.comparing(SearchResult::getDocno))
                .collect(Collectors.toList());

    }

    private static class  SearchResult {
        String docNo;

        public String getDocno() {
            return docNo;
        }
    }
}
