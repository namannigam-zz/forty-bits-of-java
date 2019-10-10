package com.stackoverflow.nullpointer.functional;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MappingFlatWithCollectorWhileReducing {

    public static void main(String[] args) {

        List<Skills> skillSet1 = Arrays.asList(new Skills("Skill-1"), new Skills("Skill-2"), new Skills("Skill-3"));
        List<Skills> skillSet2 = Arrays.asList(new Skills("Skill-1"), new Skills("Skill-4"), new Skills("Skill-2"));
        List<Skills> skillSet3 = Arrays.asList(new Skills("Skill-1"), new Skills("Skill-9"), new Skills("Skill-2"));
        List<WorkExperience> workExperienceList = Arrays.asList(new WorkExperience(2017, skillSet1),
                new WorkExperience(2017, skillSet2), new WorkExperience(2018, skillSet3));

        Map<Integer, Set<List<Skills>>> collect = workExperienceList.stream()
                .collect(Collectors.groupingBy(WorkExperience::getYear,
                        Collectors.mapping(WorkExperience::getSkill, Collectors.toSet())));
        System.out.println(collect);

        Map<Integer, Set<Skills>> collectJ9 = workExperienceList.stream().collect(Collectors.groupingBy(
                WorkExperience::getYear,
                Collectors.flatMapping(workexp -> workexp.getSkill().stream(), Collectors.toSet())));
        System.out.println(collectJ9);

        Map<Integer, Set<Skills>> map = workExperienceList.stream()
                .collect(Collectors.toMap(WorkExperience::getYear, we -> new HashSet<>(we.getSkill()),
                        (s1, s2) -> {
                            s1.addAll(s2);
                            return s1;
                        }));
        System.out.println(map);

        Map<Integer, Set<Skills>> optimizedMap = workExperienceList.stream()
                .collect(Collectors.toMap(
                        WorkExperience::getYear,
                        we -> new HashSet<>(we.getSkill()),
                        MappingFlatWithCollectorWhileReducing::mergeSkills));
        System.out.println(optimizedMap);
    }

    private static Set<Skills> mergeSkills(Set<Skills> s1, Set<Skills> s2) {
        if (s1.size() > s2.size()) {
            s1.addAll(s2);
            return s1;
        } else {
            s2.addAll(s1);
            return s2;
        }
    }

    static <T, U, A, R> Collector<T, ?, R> flatMapping(Function<? super T, ? extends Stream<? extends U>> mapper,
                                                       Collector<? super U, A, R> downstream) {

        BiConsumer<A, ? super U> acc = downstream.accumulator();
        return Collector.of(downstream.supplier(),
                (a, t) -> {
                    try (Stream<? extends U> s = mapper.apply(t)) {
                        if (s != null) s.forEachOrdered(u -> acc.accept(a, u));
                    }
                },
                downstream.combiner(), downstream.finisher(),
                downstream.characteristics().toArray(new Collector.Characteristics[0]));
    }

    @Getter
    @AllArgsConstructor
    public static class Skills {
        private String skills;
    }

    @Getter
    @AllArgsConstructor
    public static class WorkExperience {
        private int year;
        private List<Skills> skill;
    }
}