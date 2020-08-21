package edu.forty.bits.features;

/**
 * pattern matching
 * https://openjdk.java.net/jeps/305
 * https://openjdk.java.net/jeps/375
 */
public class PatternMatching {

    public static void main(String[] args) {
        /*
         * Before JEP-305
         */
        Object obj = new Object();
        String formatted = "unknown";
        if (obj instanceof Integer) {
            int i = (Integer) obj;
            formatted = String.format("int %d", i);
        } else if (obj instanceof Byte) {
            byte b = (Byte) obj;
            formatted = String.format("byte %d", b);
        } else if (obj instanceof Long) {
            long l = (Long) obj;
            formatted = String.format("long %d", l);
        } else if (obj instanceof Double) {
            double d = (Double) obj;
            formatted = String.format("double %f", d);
        } else if (obj instanceof String) {
            String s = (String) obj;
            formatted = String.format("String %s", s);
        }

        /*
         * After JEP-305
         */
        String formatting = "unknown";
        formatting = obj instanceof Float f ? String.valueOf(f.byteValue()) : "";

        if (obj instanceof Integer i) {
            formatting = String.format("int %d", i);
        } else if (obj instanceof Byte b) {
            formatting = String.format("byte %d", b);
        } else if (obj instanceof Long l) {
            formatting = String.format("long %d", l);
        } else if (obj instanceof Double d) {
            formatting = String.format("double %f", d);
        } else if (obj instanceof String s) {
            formatting = String.format("String %s", s);
        }

        // further
//        String format  = "unknown";
//        switch (obj) {
//            case Integer i: format = String.format("int %d", i); break;
//            case Byte b:    format = String.format("byte %d", b); break;
//            case Long l:    format = String.format("long %d", l); break;
//            case Double d:  format = String.format("double %f", d); break;
//            case String s:  format = String.format("String %s", s); break;
//            default:        format = obj.toString();
//        }
    }
}