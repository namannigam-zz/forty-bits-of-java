package edu.forty.bits.functional;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;


// https://stackoverflow.com/questions/61396147/
public class SQLHavingCollector {

    private static void solve(List<Item> input) {
        Map<String, List<Item>> initial = input.stream()
                .collect(Collectors.groupingBy(Item::getId))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().size() > 5)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        Map<String, List<Item>> andThen = input.stream()
                .collect(Collectors.collectingAndThen(Collectors.groupingBy(Item::getId),
                        map -> map.entrySet().stream()
                                .filter(e -> e.getValue().size() > 5)
                                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))));

        Map<String, Long> sqlCount = input.stream()
                .collect(Collectors.groupingBy(Item::getId, Collectors.counting()));
        Map<String, List<Item>> sqlGroupHavingCount = input.stream().filter(i -> sqlCount.get(i.getId()) > 5)
                .collect(Collectors.groupingBy(Item::getId));

    }

    private static void main(String... args) {
        List<Item> input = new ArrayList<>();
        Map<String, List<Item>> andThenAgain = input.stream()
                .collect(Collectors.collectingAndThen(Collectors.groupingBy(Item::getId,
                        HashMap::new, Collectors.toList()),
                        m -> {
                            m.values().removeIf(l -> l.size() <= 5);
                            return m;
                        }));

        Map<String, List<Item>> result = input.stream()
                .collect(having(Collectors.groupingBy(Item::getId), (key, list) -> list.size() > 5));

    }

    public static <T, K, V> Collector<T, ?, Map<K, V>> having(
            Collector<T, ?, ? extends Map<K, V>> c, BiPredicate<K, V> p) {
        return Collectors.collectingAndThen(c, in -> {
            Map<K, V> m = in;
            if (!(m instanceof HashMap)) m = new HashMap<>(m);
            m.entrySet().removeIf(e -> !p.test(e.getKey(), e.getValue()));
            return m;
        });
    }


    // write a custom collector
    @AllArgsConstructor
    static class Group {
        int count;
        String id;
        List<Item> items;
    }

    @Getter
    @AllArgsConstructor
    static class Item {
        String id;
    }
}