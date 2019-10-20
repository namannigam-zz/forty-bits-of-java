package edu.forty.bits.functional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopRankedCandidatesBasedOnMArks {

    public static void main(String[] args) {
        int k = 4;
        List<Integer> marks = new ArrayList<>();
        marks.add(20);
        marks.add(20);
        marks.add(40);
        marks.add(60);
        marks.add(20);
        marks.add(10);
        marks.add(0);
        marks.add(100);
        System.out.println(numOfPrizes(k, marks));
    }


    private static long numOfPrizes(int cutOffRank, List<Integer> marks) {
        return marks.stream()
                .filter(mark -> mark != 0)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .limit(cutOffRank)
                .mapToLong(Map.Entry::getValue)
                .sum();
    }
}
