package edu.forty.bits;

import java.util.Arrays;
import java.util.List;

public class __Trial__ {

    public static void main(String... ar) {
        List<String> toRemove = Arrays.asList("\u201C", "\u201D");
        List<String> toRemove1 = Arrays.asList("\u2018", "\u2019");

        String text = "KURT’X45T”YUZXC";
        for (String toRem : toRemove) {
            text = text.replaceAll(toRem, "\"");
        }
        System.out.println("---text--- " + text);

        for (String toRem : toRemove1) {
            text = text.replaceAll(toRem, "'");
        }

        System.out.println("---text--- " + text);
    }
}