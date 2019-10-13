package edu.forty.bits.findings;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Q49460751_MavenJavaDocPlugin {

    public static void main(String[] args) {
        someMethod(Stream.of(1, 2, 3), null, null);
    }


    /**
     * Method to see docs generated
     *
     * @param stream     {@link Stream} type arg
     * @param collectors {@link Collectors} type arg
     * @param math       {@link Math} type arg
     */
    public static void someMethod(Stream stream, Collectors collectors, Math math) {
        stream.close();
    }
}