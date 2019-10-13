package edu.forty.bits.functional;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static edu.forty.bits.functional.DistinctByKeys.distinctByKey;

public class GroupingAndFilteringToCount {


    public static void main(String [] args) {
        List<MyObject> myList = List.of(
                new MyObject("4", "6"),
                new MyObject("4", "4"),
                new MyObject("4", "6"),
                new MyObject("4", "7"),
                new MyObject("4", "6"),
                new MyObject("4", "8"),
                new MyObject("4", "6"),
                new MyObject("4", "0"),
                new MyObject("4", "9"),
                new MyObject("4", "1"),

                new MyObject("6", "6"),
                new MyObject("6", "0"),
                new MyObject("6", "4"),
                new MyObject("6", "6"),
                new MyObject("6", "7"),
                new MyObject("6", "6"),

                new MyObject("7", "11"));

        Map<String, Long> r = myList.stream()
                .collect(Collectors.groupingBy(MyObject::getField1))
                .entrySet().stream()
                .map(e -> new AbstractMap.SimpleEntry<>(e.getKey(),
                        e.getValue().stream().filter(distinctByKey(MyObject::getField2)).count()))
                .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue));

        Map<String, Integer> res = myList.stream()
                .collect(Collectors.groupingBy(MyObject::getField1,
                        Collectors.mapping(MyObject::getField2,
                                Collectors.collectingAndThen(Collectors.toSet(), Set::size))));

        Map<String, Long> result1 = myList.stream()
                .collect(Collectors.groupingBy(MyObject::getField1,
                        Collectors.filtering(distinctByKey(MyObject::getField2),
                                Collectors.counting())));

        Map<String, Long> result2 = myList.stream()
                .collect(Collectors.filtering(distinctByKey(MyObject::getField2),
                        Collectors.groupingBy(MyObject::getField1, Collectors.counting())));

        Map<String, Long> result3 = myList.stream()
                .filter(distinctByKey(MyObject::getField2))
                .collect(Collectors.groupingBy(MyObject::getField1, Collectors.counting()));

        System.out.println(res);
        System.out.println(r);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }

    @Getter
    @AllArgsConstructor
    static class MyObject {
        String field1;
        String field2;
    }
}
