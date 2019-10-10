package com.stackoverflow.nullpointer.functional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PreAndPostIncrementOpsWithStream {

    public static void main(String[] args) {
        Integer[] seq = {1, 3, 4, 1, 8, 11};
        List<Integer> seqFilteredPre = Arrays.stream(seq)
                .filter(i -> i % 2 != 0)
                .map(i -> ++i)
                .collect(Collectors.toList());
        System.out.println(seqFilteredPre);

        List<Integer> seqFilteredPost = Arrays.stream(seq)
                .filter(i -> i % 2 != 0)
                .map(i -> i++)
                .collect(Collectors.toList());
        System.out.println(seqFilteredPost);
    }
}