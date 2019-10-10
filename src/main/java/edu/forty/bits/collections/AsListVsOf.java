package com.stackoverflow.nullpointer.collection;

import java.util.Arrays;
import java.util.List;

public class AsListVsOf {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, null);
        list.set(1, 10); // OK

        List<Integer> anotherList = List.of(1, 2, 3);
        anotherList.set(1, 10); // Fails

        // Arrays.asList allows null elements while List.of doesn't:
        List<Integer> asList = Arrays.asList(1, 2, null); // OK
        List<Integer> ofList = List.of(1, 2, null); // Fails

        // Arrays.asList returns a view of the passed array, so the changes to the array will be reflected in the list too. For List.of this is not true:
        Integer[] array = {1,2,3};
        List<Integer> listAsArray = Arrays.asList(array);
        array[1] = 10;
        System.out.println(listAsArray); // Prints [1, 10, 3]

        Integer[] anotherArray = {1,2,3};
        List<Integer> anotherListAsArray = List.of(anotherArray);
        anotherArray[1] = 10;
        System.out.println(anotherListAsArray); // Prints [1, 2, 3]

        // contains method behaves differently with nulls:
        List<Integer> listContains = Arrays.asList(1, 2, 3);
        listContains.contains(null); // Return false

        List<Integer> anotherListContains = List.of(1, 2, 3);
        anotherListContains.contains(null); // Throws NullPointerException

    }
}
