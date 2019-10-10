package com.stackoverflow.nullpointer.stream;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class CollectAtOnceUsingStreamConcat {

    public static void main(String[] args) throws ParseException {
        Info info1 = new Info(1L, getDateFromStr("2018-02-02T10:00:00"), 3L);
        Info info2 = new Info(2L, getDateFromStr("2018-02-02T12:00:00"), 3L);
        Info info3 = new Info(3L, getDateFromStr("2018-02-05T12:00:00"), 6L);
        Info info4 = new Info(4L, getDateFromStr("2018-02-05T10:00:00"), 6L);
        List<Info> listInfo = List.of(info1, info2, info3, info4);
        Date date = getDateFromStr("2018-02-03T10:10:10");


        BiFunction<Info, Info, Info> remapping = (i1, i2) -> i1.getDate().getTime() > i2.getDate().getTime() ? i1 : i2;
        // filter 1: less date - group by maxProductOfNonOverlappingPallindromes date by groupId
        Map<Long, Info> map = new HashMap<>();
        List<Info> listMoreByDate = new ArrayList<>();
        for (Info info : listInfo) {
            if (info.getDate().getTime() < date.getTime()) {
                map.merge(info.getGroupId(), info, remapping);
            } else {
                listMoreByDate.add(info);
            }
        }
        List<Info> listResult = new ArrayList<>(map.values());
        listResult.addAll(listMoreByDate);


        // holger solved it
        List<Info> listResult2 = Stream.concat(
                listInfo.stream()
                        .filter(info -> info.getDate().getTime() < date.getTime())
                        .collect(toMap(Info::getGroupId, Function.identity(),
                                BinaryOperator.maxBy(Comparator.comparing(Info::getDate))))
                        .values().stream(),
                listInfo.stream()
                        .filter(info -> info.getDate().getTime() >= date.getTime()))
                .collect(Collectors.toList());

        System.out.println("result: " + listResult);
    }

    private static Date getDateFromStr(String dateStr) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(dateStr);
    }

    private static class Info {
        private Long id;
        private Date date;
        private Long groupId;

        Info(Long id, Date date, Long groupId) {
            this.id = id;
            this.date = date;
            this.groupId = groupId;
        }

        private Date getDate() {
            return date;
        }

        Long getGroupId() {
            return groupId;
        }
    }
}