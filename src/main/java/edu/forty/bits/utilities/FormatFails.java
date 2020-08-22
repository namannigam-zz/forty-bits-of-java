package edu.forty.bits.utilities;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Currency;
import java.util.Locale;

public class FormatFails {
    public static void main(String... args) {

        Currency currency = Currency.getInstance("EUR");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        currencyFormatter.setMaximumFractionDigits(0);
        currencyFormatter.setMinimumFractionDigits(0);
        currencyFormatter.setCurrency(currency);

        String expected = "123 457 €";
        String obtained = currencyFormatter.format(123456.789);
        System.out.println(expected.equals(obtained));
        System.out.println(expected);
        System.out.println(obtained);
        System.out.println(expected.equals(obtained));

        System.out.format("Bytes from expected: %s\n", Arrays.toString(expected.getBytes()));
        System.out.format("Bytes from expected: %s\n", Arrays.toString(obtained.getBytes()));
    }

}