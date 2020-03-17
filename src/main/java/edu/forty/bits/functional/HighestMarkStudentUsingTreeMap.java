package edu.forty.bits.functional;

import lombok.Getter;

import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class HighestMarkStudentUsingTreeMap {

    private Student highestMarkUniqueStudent(List<Student> studentList) {
        TreeMap<Integer, List<Student>> map = new TreeMap<>(studentList.stream()
                .collect(Collectors.groupingBy(Student::getMarks)));
        if (map.firstEntry().equals(map.lastEntry())) return null;
        List<Student> highestMarkStudents = map.lastEntry().getValue();
        return highestMarkStudents.size() == 1 ? highestMarkStudents.get(0) : null;
    }

    @Getter
    static class Student {
        int marks;
    }
}