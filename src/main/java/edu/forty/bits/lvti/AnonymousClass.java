package edu.forty.bits.lvti;

/**
 * Anonymous classes with var type
 */
public class AnonymousClass {

    public static void main(String[] args) {
        var o = new Object() {
            void m() {
                System.out.println("m");
            }

            void n() {
                System.out.println("n");
            }
        };
        o.m();
        o.n();
    }
}