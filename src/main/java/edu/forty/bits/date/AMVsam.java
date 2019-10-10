package com.stackoverflow.nullpointer.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AMVsam {

    public static void main(String[] args) {
        final String GAME_ZONE_TIME_DISPLAY_PATTERN = "hh:mmaaa";
        System.out.println(getTimeAsPattern(1537598975000L, GAME_ZONE_TIME_DISPLAY_PATTERN));
    }

    private static String getTimeAsPattern(long timestamp, String pattern) {
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(new Date(timestamp)).toLowerCase();
    }
}