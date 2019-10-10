package edu.forty.bits.functional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AverageByGroup {
    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
                new Item("A", 1.0),
                new Item("A", 1.0),
                new Item("B", 1.0)
        );
        double result = items.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.groupingBy(Item::getGroupName, Collectors.summingDouble(Item::getValue)),
                        map -> map.values().stream().mapToDouble(Double::doubleValue).sum() / map.size()));
        System.out.println(result);

        double res = items.stream()
                .collect(Collectors.groupingBy(Item::getGroupName, Collectors.averagingDouble(Item::getValue)))
                .entrySet().stream().mapToDouble(Map.Entry::getValue).average().orElse(Double.NaN);
        System.out.println(res);

        long distinct = items.stream().map(Item::getGroupName).distinct().count();
        double sums = items.stream().mapToDouble(Item::getValue).sum();
        System.out.println(sums / distinct);

    }

    public static class Item {
        private String groupName;
        private Double value;

        Item(String groupName, Double value) {
            this.groupName = groupName;
            this.value = value;
        }

        String getGroupName() {
            return groupName;
        }

        public Double getValue() {
            return value;
        }
    }
}