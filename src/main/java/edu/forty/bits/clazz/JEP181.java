package com.stackoverflow.nullpointer.clazz;

import java.lang.reflect.Field;

public class JEP181 {

    public static class Nest1 {

        private int varNest1;

        public void f() throws Exception {

            final Nest2 nest2 = new Nest2();

            // this was ok
            nest2.varNest2 = 2;

            // this was not ok
            final Field f2 = Nest2.class.getDeclaredField("varNest2");
            f2.setInt(nest2, 2);
            // java.lang.IllegalAccessException: Class jdk.BreakIteratorSample$Nest1 can not access a member of class
            // jdk.BreakIteratorSample$Nest2 with modifiers "private"

        }

    }

    public static class Nest2 {
        private int varNest2;
    }

    public static void main(String[] args) throws Exception {
        new Nest1().f();
    }
}