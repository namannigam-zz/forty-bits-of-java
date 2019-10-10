package edu.forty.bits.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ParseDate {

    private static String tare5 = new String();
    static String tare2 = new String();

    public static void main(String[] args) {
        // write your code here
        try {

            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy  ", Locale.ENGLISH);
            Calendar cal = Calendar.getInstance();
            Date tare4 = new Date();
            tare5 = dateFormat.format(cal.getTime());
            Date tare3 = dateFormat.parse(tare5);

            Scanner scanner = new Scanner(System.in);


            while (scanner.hasNext()) {

                String line = scanner.nextLine();
                StringTokenizer x = new StringTokenizer(line, "~");
                String[] element = new String[7];
                int counter = 0;

                while (x.hasMoreElements()) {
                    element[counter] = (String) x.nextElement();
                    counter++;

                }
                tare4 = dateFormat.parse(element[3]);

                if (tare4.getTime() >= tare3.getTime()) {
                    System.out.println(element[1] + "is expired");
                } else {
                    long def = tare3.getTime() - tare4.getTime();
                    System.out.println(element[1] + "has" + def + "to expire");
                }
            }
        } catch (ParseException pex) {
            System.out.println("hi:");
        }

    }
}