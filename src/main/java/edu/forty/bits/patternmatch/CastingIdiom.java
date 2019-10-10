package edu.forty.bits.patternmatch;

public class CastingIdiom {

    public static void main(String[] args) {
        /**
         * Before JEP-305
         */
        Object obj = new Object();
        if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            // use intValue
        }

        /**
         * After JEP-305
         */
//        if (x matches Integer i) {
//            // can use i here
//        }
//

        /*
         * Before JEP-305
         */
        String formatted = "unknown";
        if (obj instanceof Integer) {
            int i = (Integer) obj;
            formatted = String.format("int %d", i);
        }
        else if (obj instanceof Byte) {
            byte b = (Byte) obj;
            formatted = String.format("byte %d", b);
        }
        else if (obj instanceof Long) {
            long l = (Long) obj;
            formatted = String.format("long %d", l);
        }
        else if (obj instanceof Double) {
            double d = (Double) obj;
            formatted = String.format("double %f", d);
        }
        else if (obj instanceof String) {
            String s = (String) obj;
            formatted = String.format("String %s", s);
        }


        /*
         * After JEP-305
         */
//        String formatted;
//        switch (obj) {
//            case Integer i: formatted = String.format("int %d", i); break;
//            case Byte b:    formatted = String.format("byte %d", b); break;
//            case Long l:    formatted = String.format("long %d", l); break;
//            case Double d:  formatted = String.format("double %f", d); break;
//            case String s:  formatted = String.format("String %s", s); break;
//            default:        formatted = obj.toString();
//        }

    }
}