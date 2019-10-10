package edu.forty.bits.interfaces;

public interface ReverseInterface {
    @SafeVarargs
    static <T extends Comparable<T>> void sortAZ(T... elements) {
        sort("A-Z", elements);
    }

    @SafeVarargs
    static <T extends Comparable<T>> void sortZA(T... elements) {
        sort("Z-A", elements);
    }

    @SafeVarargs
    static <T extends Comparable<T>> void sort(String order,
                                               T... elements) {
        if (order.equals("A-Z")) {
            for (int pass = 0; pass < elements.length - 1; pass++)
                for (int i = elements.length - 1; i > pass; i--)
                    if (elements[i].compareTo(elements[pass]) < 0) {
                        T temp = elements[i];
                        elements[i] = elements[pass];
                        elements[pass] = temp;
                    }
        } else {
            for (int pass = 0; pass < elements.length - 1; pass++)
                for (int i = elements.length - 1; i > pass; i--)
                    if (elements[i].compareTo(elements[pass]) > 0) {
                        T temp = elements[i];
                        elements[i] = elements[pass];
                        elements[pass] = temp;
                    }
        }
    }
}