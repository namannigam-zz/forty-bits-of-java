package edu.forty.bits.utilities;

public class Compare {

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("null");
        StringBuffer anotherStringBuffer = new StringBuffer("NULL");
        System.out.println(stringBuffer.compareTo(anotherStringBuffer) == 0);
    }
}