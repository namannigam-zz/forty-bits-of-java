package com.stackoverflow.nullpointer.lang;

public class CodePointCheck {

    public static void main(String[] args) {
        String yourString = "U+00E4";
        int codepoint = Integer.parseInt(yourString.substring(2), 16);
        System.out.println(Character.toString(codepoint));

        String myString = "\u0048\u0065\u006C\u006C\u006F World";
        myString.chars().forEach(a -> System.out.print((char) a));


        "Dodd\u2013Frank".chars().forEach(a -> System.out.print((char) a));
    }
}