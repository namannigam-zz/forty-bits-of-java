package edu.forty.bits.features.records;

import lombok.AllArgsConstructor;

// https://stackoverflow.com/questions/60795837/java-records-and-lombok-annotation-intellij
public class MixOfWorldsWithLombok {

    public static void main(String[] args) {
        System.out.println(new Java("14", true).version());
    }

    @AllArgsConstructor
    private record Java(String version, boolean preview) {
    }
}