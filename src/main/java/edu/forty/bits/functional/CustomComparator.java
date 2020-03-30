package edu.forty.bits.functional;

import java.util.Comparator;
import java.util.function.ToIntFunction;

public class CustomComparator {

    // https://stackoverflow.com/questions/60914762/ignore-zero-values-at-sorted-in-lambda
    public static <T> Comparator<T> zerosLast(ToIntFunction<? super T> keyExtractor) {
        return (o1, o2) -> {
            if (keyExtractor.applyAsInt(o1) == 0)
                return keyExtractor.applyAsInt(o2) == 0 ? 0 : 1;
            else
                return keyExtractor.applyAsInt(o2) == 0 ? -1 :
                        Integer.compare(keyExtractor.applyAsInt(o1),
                                keyExtractor.applyAsInt(o2));
        };
    }
}
