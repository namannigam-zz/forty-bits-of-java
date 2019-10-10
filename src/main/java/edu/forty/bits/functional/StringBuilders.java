package com.stackoverflow.nullpointer.functional;

import java.util.ArrayList;
import java.util.List;

public class StringBuilders {

    public static void main(String[] args) {
        final StringBuilder xBuilder = new StringBuilder();
        final StringBuilder yBuilder = new StringBuilder();
        final StringBuilder zBuilder = new StringBuilder();

        List<Obj> someObjects = new ArrayList<>();
        someObjects.forEach(obj -> {
            A a = obj.getA();
            xBuilder.append(obj.getX()).append(",");
            yBuilder.append(obj.getY()).append(",");
            zBuilder.append(a.getZ()).append(",");
        });
    }

    private static class Obj {
        private A a;
        private String x;
        private String y;

        public String getX() {
            return x;
        }

        public String getY() {
            return y;
        }

        public A getA() {
            return a;
        }
    }

    private static class A {

        private String z;

        String getZ() {
            return z;
        }
    }
}