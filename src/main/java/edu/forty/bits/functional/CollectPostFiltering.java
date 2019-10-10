package com.stackoverflow.nullpointer.functional;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectPostFiltering {

    private Set<Student> getFilteredSet() {
        Set<Student> unfilteredSet = new HashSet<>();
        Set<Student> adminAreaSet = new HashSet<>();
        Set<String> adminAreaID = adminAreaSet.stream()
                .map(Student::getId)
                .collect(Collectors.toSet());

        return unfilteredSet.stream()
                .filter(student -> adminAreaID.contains(student.getId()))
                .collect(Collectors.toSet());

    }

    private static class Student {
        String id;

        String getId() {
            return id;
        }
    }
}