package edu.forty.bits.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTrial {

    public static void main(String[] args) {
        // write your code here
        String s = "<,Bold,>, ,This, ,is, ,a, ,test";
        System.out.println(s.replace(",", ""));

        try {
            Date today = new Date();
            String Resolved = "17-04-2015 03:54";
            Date date = new SimpleDateFormat("dd-MM-yyyy HH:mm").parse(Resolved);
            System.out.println(date.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}