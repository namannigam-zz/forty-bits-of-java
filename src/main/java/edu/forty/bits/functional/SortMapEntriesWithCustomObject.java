package edu.forty.bits.functional;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

public class SortMapEntriesWithCustomObject {

    private static void solve() {
        List<Customer> customerList = Arrays.asList(
                new Customer("John", 2, 15),
                new Customer("John", 4, 15),
                new Customer("John", 6, 25),
                new Customer("Joe", 3, 15),
                new Customer("Joe", 3, 15),
                new Customer("Joe", 3, 15),
                new Customer("Goerge", 6, 25),
                new Customer("Goerge", 6, 25),
                new Customer("Mary", 7, 25),
                new Customer("Jane", 1, 15),
                new Customer("Jane", 2, 15),
                new Customer("Jane", 8, 25),
                new Customer("Jane", 8, 25)
        );

        Map<DiscountCounts, Long> collectSortedEntries = customerList
                .stream()
                .collect(Collectors.groupingBy(x -> new DiscountCounts(x.name, x.discount),
                        Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparing((Map.Entry<DiscountCounts, Long> e) -> e.getKey().getName())
                        .thenComparing(e -> e.getKey().getDiscount()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (a, b) -> a, LinkedHashMap::new));


        // collecting tp TreeMap makes more sense because of the transformation
        // and feasibility to implement Comparable for the custom object
        Map<DiscountCounts, Long> result1 = customerList.stream()
                .collect(Collectors.groupingBy(c -> new DiscountCounts(c.getName(), c.getDiscount()),
                        TreeMap::new, Collectors.counting()));
    }

    @Getter
    @AllArgsConstructor
    static class Customer {
        public String name;
        public int age;
        public int discount;
    }

    @Getter
    @AllArgsConstructor
    static class DiscountCounts implements Comparable<DiscountCounts> {
        public String name;
        public Integer discount;

        @Override
        public int compareTo(DiscountCounts o) {
            int compareName = this.getName().compareTo(o.getName());
            int compareDiscount = this.getDiscount().compareTo(o.getDiscount());
            return compareName == 0 ? compareDiscount : compareName;
        }
    }
}
