package edu.forty.bits.text;

import java.text.NumberFormat;
import java.util.Locale;

public class FormatNumberShort {

    public static void main(String[] args) {
        NumberFormat fmt = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
        System.out.println(fmt.format(1000));
        System.out.println(fmt.format(100000));
        System.out.println(fmt.format(10000000));
        System.out.println(fmt.format(5501));
        System.out.println(fmt.format(12034));
    }
}