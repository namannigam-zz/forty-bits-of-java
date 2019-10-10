package com.stackoverflow.nullpointer.interfaces;

public class InnerInterface {

    public static void main(String[] args) {
        new C().process();
    }

    interface B {
        static void execute() {
            System.out.println("Test of B interface!");
        }

        default void process() {
            System.out.println("Test2 of interface!");
        }
    }

    static class C implements B {
        void test() {
            System.out.println("Test of class C!");
            B.execute();
        }

        @Override
        public void process() {
            test();
            System.out.println("This is process of sub child!");
        }
    }

    interface D extends B {
        @Override
        default void process() {
            System.out.println("D defaul process.");
        }

        public void execute();
    }
}