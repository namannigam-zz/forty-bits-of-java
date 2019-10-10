package edu.forty.bits.date;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class LunarCalendar {

    public static void main(String[] args) {

        Date date = Date.from(Instant.now()); // your date
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        System.out.println(year);
        System.out.println(month);
        System.out.println(day);
    }
}