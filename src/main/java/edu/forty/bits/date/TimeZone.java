package com.stackoverflow.nullpointer.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;

public class TimeZone {

    public static void main(String[] args) throws ParseException {
        System.out.println(buildDate(7, 9, 2017, 15, 15).toString());
    }


    private static Date buildDate(int day, int month, int year, int hours, int minutes) throws ParseException {
        DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy/HH/mm");
        sdf.setTimeZone(java.util.TimeZone.getTimeZone("EDT"));
        Date d = null;
        try {
            String space = "/";
            String dateC = day + space + month + space + year + space + hours + space + minutes;
            String dateZ = "09/07/2017/08/38";
            d = sdf.parse(dateC);
            sdf.setTimeZone(java.util.TimeZone.getTimeZone(ZoneId.of("UTC")));
            String newRawDate = sdf.format(d);
            d = sdf.parse(newRawDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(d);
        return d;
    }
}