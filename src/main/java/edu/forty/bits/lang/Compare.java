package com.stackoverflow.nullpointer.lang;

public class Compare {

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("null");
        StringBuffer anotherStringBuffer = new StringBuffer("NULL");
        System.out.println(stringBuffer.compareTo(anotherStringBuffer) == 0);
    }
}