package edu.forty.bits.lang;

import java.io.IOException;

public class FilePathRawStrings {

    // TODO : intelliJ Update for Java 14
    public static void main(String[] args) throws IOException {
        // Before JEP-326
        Runtime.getRuntime().exec("\"C:\\Program Files\\foo\" bar");
        // After JEP-326
//        Runtime.getRuntime().exec(`"C:\Program Files\foo" bar`);

     }
}
