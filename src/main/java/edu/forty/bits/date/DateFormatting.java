package com.stackoverflow.nullpointer.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatting {

    public static void main(String[] args) {

        Long epochDate = 1471285800000L;
        Date date = new Date(epochDate);
        SimpleDateFormat dateFormat = new SimpleDateFormat(Constant.SOME_DATE_FORMAT);
        dateFormat.format(date);
        System.out.println("dateFormat = " + dateFormat.format(date).toString());
    }


    class Constant {
        //    4:00 PM, 21 July, 2016
        static final String SOME_DATE_FORMAT = "d MMM, yyyy, hh:mm a";
    }
}