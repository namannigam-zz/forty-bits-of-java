package com.stackoverflow.nullpointer.functional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorOnTwoFields {

    class AClass {
        String var2;
        String var1;

        String getVar2() {
            return var2;
        }

        String getVar1() {
            return var1;
        }
    }

    public static void main(String[] args) {
        List<AClass> list = new ArrayList<>();
        list.sort(Comparator.comparing(AClass::getVar1).thenComparing(AClass::getVar2).reversed());
    }
}