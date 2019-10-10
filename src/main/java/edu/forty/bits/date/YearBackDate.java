package edu.forty.bits.date;

import java.util.Date;

public class YearBackDate {

    public static void main(String[] args) {
        // write your code here

        Date dt = new Date(), tenYrs = new Date(), twentyYrs = new Date();
        System.out.print(dt.toString());
        String tenYears = dt.clone().toString();
        dt.after(dt);
    }
}