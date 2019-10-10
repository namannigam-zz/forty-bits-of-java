package edu.forty.bits.lang;

public class RegexRawStrings {

    //TODO :  intelliJ update for Java14
    public static void main(String[] args) {
        // Before JEP-326
        System.out.println("this".matches("\\w\\w\\w\\w"));
        // After JEP-326
//        System.out.println("this".matches(`\w\w\w\w`));
    }
}
