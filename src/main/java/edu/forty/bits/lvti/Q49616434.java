package edu.forty.bits.lvti;

import java.util.*;

public class Q49616434 {

    public static void main(String[] args) {
        distinct(List.of(1, 2, 3), Comparator.naturalOrder());
        distincts(List.of(1, 2, 3), Comparator.naturalOrder());
        System.out.println("Done");
    }

    private static <T> Set<T> distinct(Collection<? extends T> list, Comparator<? super T> comparator) {
        Set<T> set = new TreeSet<>(comparator);
        set.addAll(list);
        return set;
    }

    private static <T> Set<T> distincts(Collection<? extends T> list, Comparator<? super T> comparator) {
        var set = new TreeSet<T>(comparator);
        set.addAll(list);
        return set;
    }
}