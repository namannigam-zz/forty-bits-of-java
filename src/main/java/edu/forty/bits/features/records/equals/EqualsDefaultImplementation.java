package edu.forty.bits.features.records.equals;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EqualsDefaultImplementation {

    public static void main(String[] args) {
        List<City> cities = List.of(
                new City(1, "one"),
                new City(2, "two"),
                new City(3, "three"),
                new City(2, "two"));
        Map<City, Long> cityListMap = cities.stream()
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));
        System.out.println(cityListMap);

        List<CityRecord> cityRecords = List.of(
                new CityRecord(1, "one"),
                new CityRecord(2, "two"),
                new CityRecord(3, "three"),
                new CityRecord(2, "two"));
        Map<CityRecord, Long> cityRecordListMap = cityRecords.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(cityRecordListMap);
    }
}