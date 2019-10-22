package edu.forty.bits.functional;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitionGroupSummingInt {

    public static void main(String[] args) {
        List<Officer> off = new ArrayList<>();
        int totalDaysInOffice = off.stream().mapToInt(Officer::getTotalDaysInOffice).sum();

        List<Officer> officerList = Arrays.asList(new Officer("John", 5000),
                new Officer("Matthew", 3000), new Officer("Robert", 2000),
                new Officer("Dave", 2000), new Officer("Patrick", 10000));

        Map<Boolean, Map<Officer, Integer>> collect = officerList.stream()
                .collect(Collectors.partitioningBy(o -> o.getTotalDaysInOffice() >= 10000,
                        Collectors.groupingBy(o -> o, Collectors.summingInt(Officer::getTotalDaysInOffice))));
        System.out.println(collect);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    static class Officer {
        private String name;
        private int totalDaysInOffice;
    }
}