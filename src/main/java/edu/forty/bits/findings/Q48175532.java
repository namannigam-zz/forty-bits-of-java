package com.stackoverflow.nullpointer.findings;

/**
 * @link <href>https://stackoverflow.com/questions/48175532</href>
 * Exception in thread "main" java.lang.NoSuchFieldError: super
 * at A$C.test(A.java:15)
 * at A.main(A.java:5)
 */
public class Q48175532 {
    public static void main(String[] args) {
        new C().test();
    }

    interface B {
        private void test() {
        }
    }

    static class C implements B {
        void test() {
            B.super.test();
        }
    }

    //<href>https://bugs.java.com/bugdatabase/view_bug.do?bug_id=JDK-8194847</href>
}