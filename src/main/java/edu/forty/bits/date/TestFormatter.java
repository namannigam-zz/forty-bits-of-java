package edu.forty.bits.date;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class TestFormatter {

    public static void main(String[] args) {
        DateTimeFormatter f = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG, FormatStyle.LONG);

        OffsetDateTime odt = OffsetDateTime.now(ZoneId.systemDefault());
        ZonedDateTime zdt = odt.atZoneSameInstant(
                odt.getOffset());  // Generate a `ZonedDateTime` with same moment and same offset as the `OffsetDateTime`.

        // Succeeds.
        String outputZdt = zdt.format(f);
        System.out.println("outputZdt: " + outputZdt);

        // Fails. Throws jdk.exception.
        String outputOdt = odt.format(f);  // Throws jdk.exception.
        System.out.println("outputOdt: " + outputOdt);

    }
}