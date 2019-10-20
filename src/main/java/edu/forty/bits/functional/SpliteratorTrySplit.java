package edu.forty.bits.functional;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SpliteratorTrySplit {

    /*
     *  Some sources admit better implementations than others:
     *  an ArrayList with more than one element can always be split cleanly and evenly;
     *  a LinkedList always splits poorly;
     *  and hash-based and tree-based sets can generally be split reasonably well
     */

    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<>(Set.of("", "s"));
        String[] sortedAWords = ts.stream()
                .filter(s -> s.startsWith("a"))
                .sorted() // no-op
                .toArray(String[]::new);
    }

    /*
     * The easiest way to make a spliterator, but which results in the worst-quality result,
     * is to pass an Iterator to Spliterators.spliteratorUnknownSize().
     * You can obtain a slightly better spliterator by passing an Iterator and a size to Spliterators.spliterator.
     * But if stream performance is important - especially, parallel performance -
     * implement the full Spliterator interface, including all applicable characteristics.
     */
}