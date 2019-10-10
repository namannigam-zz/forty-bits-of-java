package com.stackoverflow.nullpointer.collection;

import java.util.List;

public class ListZero {

    public static void main(String[] args) {
        List<String> list = List.of();
        System.out.println(list.get(4));
    }
}
