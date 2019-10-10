package com.stackoverflow.nullpointer.lang;

public class RegexRawStrings {

    public static void main(String[] args) {
        // Before JEP-326
        System.out.println("this".matches("\\w\\w\\w\\w"));
        // After JEP-326
        System.out.println("this".matches(`\w\w\w\w`));
    }
}
