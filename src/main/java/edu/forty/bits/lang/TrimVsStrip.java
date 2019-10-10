package edu.forty.bits.lang;

public class TrimVsStrip {

    public static void main(String[] args) {
        String emptyString = "";
        System.out.println(emptyString.strip());
        System.out.println(emptyString.trim());
        String whiteSpace = " 123 456 ";
        System.out.println(whiteSpace.trim().length());
        System.out.println(whiteSpace.strip().length());

        System.out.println("".strip());
        System.out.println("  both  ".strip());
        System.out.println("  some com.stackoverflow.nullpointer.string with whitespace  \n \t leading character  ".strip());
        System.out.println("  some com.stackoverflow.nullpointer.string with whitespace  \n \t leading character  ".trim());
        System.out.println("trailing  ".strip());
        System.out.println("trailing  ".trim());
    }
}
