package edu.forty.bits.functional;

import java.util.stream.IntStream;

public class CompareStringsDifference {

    public static void main(String[] args) {
        String str1 = "ABCDEFG";
        String str2 = "ABCDEEG";
        System.out.println(IntStream.range(0, str1.length()).filter(i -> str1.charAt(i) != str2.charAt(i)).count());
    }

}