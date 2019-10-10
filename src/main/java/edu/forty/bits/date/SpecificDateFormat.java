package edu.forty.bits.date;

import java.text.DateFormatSymbols;
import java.util.Calendar;

public class SpecificDateFormat {

    public static void main(String[] args) {
        long time = 1537243519000L;
        System.out.println(getDateAndMonthWithSuffix(convertTimestampToCalendar(time)));
    }
    private static Calendar convertTimestampToCalendar(long timestamp) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(timestamp);
        return cal;
    }

    private static String getDateAndMonthWithSuffix(Calendar calendar) {
        String month = new DateFormatSymbols().getShortMonths()[calendar.get(Calendar.MONTH)];
        int day = calendar.get(Calendar.DATE);
        return String.format("%d%s %s, %d", day, getDayOfMonthSuffix(day), month, calendar.get(Calendar.YEAR));
    }

    private static String getDayOfMonthSuffix(int n) {
        if (n >= 11 && n <= 13) {
            return "th";
        }
        switch (n % 10) {
            case 1:
                return "st";
            case 2:
                return "nd";
            case 3:
                return "rd";
            default:
                return "th";
        }
    }
}
