package edu.forty.bits.interfaces;

class ImpFunctInterface {
    private interface FunctionalInterface {
        void activate(ImpFunctInterface a);
    }

    void foo(FunctionalInterface f) {
        ImpFunctInterface a = new ImpFunctInterface();
        f.activate(a);
    }

    public static void main(String[] args) {
        new ImpFunctInterface().foo(System.out::println);
    }
}