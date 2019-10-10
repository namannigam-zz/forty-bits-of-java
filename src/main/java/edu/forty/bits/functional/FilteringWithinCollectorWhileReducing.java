package com.stackoverflow.nullpointer.functional;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FilteringWithinCollectorWhileReducing {

    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("A", 5000, "A1"));
        list.add(new Employee("B", 1000, "B1"));
        list.add(new Employee("C", 6000, "C1"));
        list.add(new Employee("C", 7000, "C2"));

        Map<String, List<Employee>> collect = list.stream()
                .filter(e -> e.getSalary() > 2000)
                .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(collect);

        Map<String, List<Employee>> output = list.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.filtering(e -> e.getSalary() > 2000, Collectors.toList())));

        System.out.println(output);
    }


    public static <T, A, R> Collector<T, ?, R> filtering(
            Predicate<? super T> predicate, Collector<? super T, A, R> downstream) {

        BiConsumer<A, ? super T> accumulator = downstream.accumulator();
        return Collector.of(downstream.supplier(),
                (r, t) -> {
                    if (predicate.test(t)) accumulator.accept(r, t);
                },
                downstream.combiner(), downstream.finisher(),
                downstream.characteristics().toArray(new Collector.Characteristics[0]));
    }

    @Getter
    @AllArgsConstructor
    public static class Employee {
        private String department;
        private Integer salary;
        private String name;
    }
}