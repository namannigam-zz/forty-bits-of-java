package com.stackoverflow.nullpointer.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateNano {

    public static void main(String[] args) {
        String strDate = "2017-08-23-11.19.02.234850";
        String dateFmt = "yyyy-MM-dd-HH.mm.ss.SSSSSS";

        System.out.println("converted Date: " + convertDate(strDate, dateFmt));
    }

    public static String convertDate(String strDate, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);
        sdf.setLenient(true);

        try {
            Date dateIn = sdf.parse(strDate);
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS").format(dateIn.getTime());

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "";
    }
}