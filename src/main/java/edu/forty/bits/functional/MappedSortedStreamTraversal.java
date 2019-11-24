package edu.forty.bits.functional;

import edu.forty.bits.__Trial__;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class MappedSortedStreamTraversal {

    // https://stackoverflow.com/questions/58960735/why-does-iterating-a-mapped-sorted-stream-evaluate-more-elements-than-necessary
    private static final List<Character> ALPHABET = List.of('a', 'b', 'c', 'd', 'e', 'f');
    private static final int STOP_ORDINAL = 'b' - 'a';

    public static void main(String[] args) {

        System.out.println("java.runtime.version = " + System.getProperty("java.runtime.version"));

        Stream<Integer> ordinals = ALPHABET.stream()
                .sorted()
                .map(MappedSortedStreamTraversal::ordinal);

        int count = 0;

        Iterator<Integer> iterator = ordinals.iterator();
        while (iterator.hasNext()) {
            int ordinal = iterator.next();
            if (ordinal > STOP_ORDINAL) {
                System.out.println("stopping at " + ordinal);
                break;
            }
            System.out.println("consuming " + ordinal);
            ++count;
        }

        System.out.println("consumed " + count + " ordinals");
    }

    private static int ordinal(char letter) {
        int ordinal = letter - 'a';
        System.out.println("performing EXTREMELY EXPENSIVE mapping of " + letter + " -> " + ordinal);
        return ordinal;
    }
}