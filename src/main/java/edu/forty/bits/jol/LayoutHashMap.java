package edu.forty.bits.jol;

import org.openjdk.jol.info.GraphLayout;

import java.util.ArrayList;
import java.util.List;

public class LayoutHashMap {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>(2);
        List<String> list3 = new ArrayList<>(5);
        List<String> list4 = new ArrayList<>(8);
        System.out.println(GraphLayout.parseInstance(list1).toFootprint());
        System.out.println(GraphLayout.parseInstance(list2).toFootprint());
        System.out.println(GraphLayout.parseInstance(list3).toFootprint());
        System.out.println(GraphLayout.parseInstance(list4).toFootprint());
        list1.add("foo");
        list2.add("foo");
        list3.add("foo");
        list4.add("foo");
        System.out.println(GraphLayout.parseInstance(list1).toFootprint());
        System.out.println(GraphLayout.parseInstance(list2).toFootprint());
        System.out.println(GraphLayout.parseInstance(list3).toFootprint());
        System.out.println(GraphLayout.parseInstance(list4).toFootprint());



    }
}
