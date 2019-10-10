package com.stackoverflow.nullpointer.jdk09.challenges;

public class Challenge5 {

    public static void main(String[] args) {
        int num1 = 7;
        int num2 = 7;

        if (num1 > num2 && num1++ > ++num2) {
            num1++;
        }

        if (++num2 > num1 || num1++ == num2++) {
            num1++;
        }

        System.out.println(num1 + ":" + num2);
    }
}