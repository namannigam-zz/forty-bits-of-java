package com.stackoverflow.nullpointer.lang;

public class CheckVersion {

    public static void main(String[] args) {
        System.out.println(Runtime.version());
        Runtime.Version version = Runtime.Version.parse("9");
        version = Runtime.Version.parse("9.0.1");
        version = Runtime.Version.parse("9.0.0.15");
        version = Runtime.Version.parse("9.0.0.15+181");

        System.out.println(System.getProperty("java.specification.version"));
        System.out.println(getMajorVersion());
    }

    private static int getMajorVersion() {
        String systemVersionProperty = System.getProperty("java.specification.version");
        return systemVersionProperty.contains(".") ? Integer.parseInt(systemVersionProperty.substring(2)) :
                Integer.parseInt(systemVersionProperty);
    }
}