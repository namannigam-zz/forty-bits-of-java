package edu.forty.bits.utilities;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Time {
    public static void main(String[] args) {
        Duration duration = Duration.ofDays(4);
        System.out.println(TimeUnit.SECONDS.convert(duration));
    }
}
