package edu.forty.bits.features.lvti;

import java.util.Comparator;
import java.util.List;

/**
 * Readability shoudln't be compromised
 * Keyword should be used in local scope
 */
public class UtilInferences {

    public static void main(String[] args) {

        Integer x = Integer.valueOf(150);
        System.out.println(x);
        var list = List.of('A', 'B', 'C');
        var stream = list.stream();
        var optional = stream.max(Comparator.naturalOrder());
        System.out.println(list.getClass());
        System.out.println(stream.getClass());
        System.out.println(optional.getClass());
    }
}