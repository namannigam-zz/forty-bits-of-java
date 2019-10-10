package com.stackoverflow.nullpointer.functional;

import java.util.Arrays;

public class IntToColors {

    enum Colors {
        RED(0),
        BLUE(1),
        GREEN(2);

        private int color;

        public int getColor() {
            return color;
        }

        Colors(final int color) {
            this.color = color;
        }

        public int getValue() {
            return color;
        }
    }

    public static class A {

        static Colors intToColor(final int colorValue) {
            return Arrays.stream(Colors.values()).filter(c -> colorValue == c.getValue()).findFirst().orElseThrow(() -> new IllegalArgumentException("Exception"));
        }

        public static void main(String[] args) {
            try {
                System.out.println(intToColor(2));
            } catch (Exception e) {
                // Exception
            }

        }
    }
}
