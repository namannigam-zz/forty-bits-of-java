package com.stackoverflow.nullpointer.jdk09.challenges;

public class Challenge3 {

    public static void main(String[] args) {
        String var1 = "null";
        String var2 = null;

        System.out.println(var1.equals(var2));
        System.out.println(var1 == null);

        String result = var1.replaceAll("\\w","a");
        System.out.println(result);
    }
}
