package edu.forty.bits.time;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class DateTimeSample {

    public static void main(String[] args) {
        Duration d = Duration.between(Instant.now(), Instant.now());
        System.out.println(d.toDays()); // 0
        System.out.println(d.get(ChronoUnit.NANOS));
    }
}
