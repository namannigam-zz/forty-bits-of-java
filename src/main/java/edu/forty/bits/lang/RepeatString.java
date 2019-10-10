package com.stackoverflow.nullpointer.lang;

public class RepeatString {

    public static void main(String[] args) {
        //UseCase1
        String name = "stackoverflow";
        name += name.repeat(2);
        System.out.println(name);

        //UseCase2
        String str = "do";
        String res = str + str.repeat(3);
        System.out.println(res);

        //UseCase3
        int i = 3;
        String ch = "0";
        String someNum = "123";
        someNum = someNum + ch.repeat(i);
        System.out.println(someNum);
    }
}