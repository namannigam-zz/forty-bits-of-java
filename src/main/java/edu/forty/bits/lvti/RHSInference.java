package com.stackoverflow.nullpointer.lvti;

import java.util.ArrayList;
import java.util.List;

public class RHSInference {

    public static void main(String[] args) {
        var list = List.of(1, 3, 2);
//        var list = List.of(1, 3, "three");

        var anonymous = new ArrayList<>() {
        };

        ArrayList arrayList = new ArrayList<>();

        var varList = new ArrayList<>();

//        var mix = new ArrayList<>(List.of("2",3));
//        System.out.println(mix);

        var list1 = new ArrayList<>();
//        List<Number> numberList = list1;
//        System.out.println(numberList);

        ArrayList list2 = new ArrayList<>();
        List<Number> numberList1 = list2;
        System.out.println(numberList1);

    }
}