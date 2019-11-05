package edu.forty.bits.functional;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PartitionUsesListInsteadOfSet {

    @Getter
    @AllArgsConstructor
    static class Person {
        String name;
        int age;
    }

    public static void trial(List<Person> persons) {
        Collector<Person, ?, LinkedHashMap<String, String>> downstream =
                Collectors.toMap(Person::getName, Person::getName, (a, b) -> a, LinkedHashMap::new);
        Map<Boolean, LinkedHashMap<String, String>> mapped = persons.stream()
                .collect(Collectors.partitioningBy(p -> p.getName().startsWith("P"), downstream));
        System.out.println(mapped);
    }

    private static final class Partition<T>
            extends AbstractMap<Boolean, T>
            implements Map<Boolean, T> {
        final T forTrue;
        final T forFalse;

        Partition(T forTrue, T forFalse) {
            this.forTrue = forTrue;
            this.forFalse = forFalse;
        }

        @Override
        public Set<Map.Entry<Boolean, T>> entrySet() {
            return new AbstractSet<>() {
                @Override
                public Iterator<Map.Entry<Boolean, T>> iterator() {
                    Map.Entry<Boolean, T> falseEntry = new SimpleImmutableEntry<>(false, forFalse);
                    Map.Entry<Boolean, T> trueEntry = new SimpleImmutableEntry<>(true, forTrue);
//                    return Set.of(falseEntry, trueEntry).iterator();
                    // not documented though, this brings a slightly improved performance for
                    // creation of collection instead of Set.of which checks for unique contents as well
                    return List.of(falseEntry, trueEntry).iterator();
                }

                @Override
                public int size() {
                    return 2;
                }
            };
        }
    }
}