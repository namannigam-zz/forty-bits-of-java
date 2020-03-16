package edu.forty.bits.collections;

import java.util.*;
import java.util.stream.Stream;

public class CollectionUtility {

    public static void main(String[] args) {
        // interesting generics
        SortedSet<int[]> all = new TreeSet<>((a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            } else {
                return Integer.compare(a[0], b[0]);
            }
        });


        // Substitute appropriate type.
        ArrayList<Integer> alist = new ArrayList<>();
        Collections.reverse(alist);
        alist.forEach(System.out::println);

        // Add elements to list.

        // Generate an iterator. Start just after the last element.
        ListIterator li = alist.listIterator(alist.size());
        // Iterate in reverse.
        while (li.hasPrevious()) {
            System.out.println(li.previous());
        }
    }


    private static <T> Set<T> distinct(Collection<? extends T> list, Comparator<? super T> comparator) {
        Set<T> set = new TreeSet<>(comparator);
        set.addAll(list);
        return set;
    }

    public static boolean isAllEmptyOrNull(Collection... collectionList) {
        return Arrays.stream(collectionList).allMatch(Collection::isEmpty);
    }

    public static boolean isAllEmptyOrNull(Map... maps) {
        return Arrays.stream(maps).allMatch(Map::isEmpty);
    }


    public static boolean collectionIsNullOrEmpty(Stream<Collection> collectionStream) {
        return collectionStream.anyMatch(item -> item == null || item.isEmpty());
    }
}
