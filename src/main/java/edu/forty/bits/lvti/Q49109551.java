package com.stackoverflow.nullpointer.lvti;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class Q49109551 {

    public static void main(String[] args) {
        var x = new DateTimeFormatterBuilder()
                .append(DateTimeFormatter.BASIC_ISO_DATE)
                .appendLiteral('-')
                .append(DateTimeFormatter.ISO_LOCAL_TIME)
                .toFormatter();

//        x.parse("20180302-17:45:21");

        var y = new DateTimeFormatterBuilder()
                .append(DateTimeFormatter.BASIC_ISO_DATE)
                .appendLiteral('-')
                .append(DateTimeFormatter.ISO_LOCAL_TIME)
                .toFormatter();

        y.parse("20180302-17:45:21");
    }
}