package edu.forty.bits.lvti;

import java.util.ArrayList;

public class Q49928780_RawTypeWarn {

    public static void main(String[] args) {
        ArrayList x = new ArrayList();
        x.add("1");
        x.add(true);
        System.out.println(x);

        Object a = new ArrayList<>();
        ((ArrayList) a).add("1");
        ((ArrayList) a).add(true);
        System.out.println(a);

        ArrayList<Object> y = new ArrayList<>();
        y.add("1");
        y.add(false);
        System.out.println(y);

        var b = new ArrayList<>();
        b.add("1");
        b.add(false);
        System.out.println(b);
    }
}