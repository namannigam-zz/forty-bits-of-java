package com.stackoverflow.nullpointer.functional;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class BreakIteratorSample {

    public static void main(String[] args) throws Exception {
        String text = "This is a test";
        List<String> words = new ArrayList<String>();
        java.text.BreakIterator breakIterator = java.text.BreakIterator.getWordInstance();

        breakIterator.setText(text);

        int lastIndex = breakIterator.first();

        while (java.text.BreakIterator.DONE != lastIndex) {
            int firstIndex = lastIndex;
            lastIndex = breakIterator.next();
            if (lastIndex != java.text.BreakIterator.DONE) {
                String t = text.substring(firstIndex, lastIndex);
                words.add(t);
            }
        }
        System.out.println(words.toString());

        new Nest1().f();
    }


    public static class Nest1 {

        private int varNest1;

        public void f() throws Exception {

            final Nest2 nest2 = new Nest2();

            // this is ok
            nest2.varNest2 = 2;

            // this is not ok
            final Field f2 = Nest2.class.getDeclaredField("varNest2");
            f2.setInt(nest2, 2);

        }

    }

    public static class Nest2 {
        private int varNest2;
    }

}