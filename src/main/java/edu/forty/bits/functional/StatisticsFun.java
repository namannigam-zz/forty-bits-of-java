package com.stackoverflow.nullpointer.functional;

import java.util.IntSummaryStatistics;

public class StatisticsFun {

    public static void main(String[] args) {
        var intsummstats = new IntSummaryStatistics();
        var intsummstats3 = new IntSummaryStatistics(0, 12, 100, 1000);
        var intsummstats4 = new IntSummaryStatistics(2, 1, 2, 1);

//        intsummstats3.combine(intsummstats4);
//        intsummstats4.combine(intsummstats3);

        System.out.println(intsummstats);
        System.out.println(intsummstats3);
        System.out.println(intsummstats4);
    }
}