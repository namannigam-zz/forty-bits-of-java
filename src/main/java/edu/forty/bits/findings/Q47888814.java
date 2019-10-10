package com.stackoverflow.nullpointer.findings;

import java.util.Arrays;

/**
 * @see <href>https://stackoverflow.com/questions/47888814</href>
 *
 * Output ::
 * Sample1
 * Sample2
 * Sample3
 * Sample5
 *
 * Expected ::
 * Sample1
 * Sample2
 * Sample3
 */
public class Q47888814 {

    public static void main(String[] args) {
        String[][] strArray = {{"Sample1", "Sample2"}, {"Sample3", "Sample4", "Sample5"}};

        Arrays.stream(strArray)
                .flatMap(Arrays::stream)
                .takeWhile(ele -> !ele.equalsIgnoreCase("Sample4"))
                .forEach(System.out::println);
    }

    // <href>https://bugs.openjdk.java.net/browse/JDK-8193856</href>
}