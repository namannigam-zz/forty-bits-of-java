package edu.forty.bits.functional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectorVsCollectionsSort {

    //  use the streams API to sort a List<DateRange> by int member startRange
    public static void main(String[] args) {
        List<DateRange> listToBeSorted = new ArrayList<>();

        List<DateRange> sortedList = listToBeSorted.stream()
                .sorted(Comparator.comparingInt(DateRange::getStartRange))
                .collect(Collectors.toList());

        Comparator<DateRange> comparator = Comparator.comparing(DateRange::getStartRange);
        listToBeSorted.sort(comparator);

        System.out.println(sortedList);
    }

    static private class DateRange {
        private int startRange;
        private int endRange;

        int getStartRange() {
            return startRange;
        }
    }

    void someHolgerCode() {
        int listSize = 10, maxWordSize = 10;
        int[] letters = IntStream.range('A', 'Z').toArray();
        List<String> random = IntStream.range(0, listSize)
                .mapToObj(ix -> ThreadLocalRandom.current()
                        .ints(ThreadLocalRandom.current().nextInt(1, maxWordSize), 0, letters.length)
                        .map(i -> letters[i])
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                        .toString())
                .collect(Collectors.toCollection(ArrayList::new));
    }
}