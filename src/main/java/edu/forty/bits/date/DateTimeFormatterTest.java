package com.stackoverflow.nullpointer.date;

import java.time.DayOfWeek;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeFormatterTest {

    public static void main(String[] args) {
        System.out.println(System.getProperty("java.locale.providers"));
        //        java.locale.providers=JRE,SPI
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("eee", Locale.GERMAN);

        String format = dtf.format(DayOfWeek.MONDAY);
        System.out.println("format = " + format);

        DayOfWeek mo = dtf.parse("Mo", DayOfWeek::from);
        System.out.println("mo = " + mo);

    }
}