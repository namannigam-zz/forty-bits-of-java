package edu.forty.bits.inheritence;

public class SuperInstanceSuperMethodInvocation {

    static class Jedi {
        static void attack() {
            System.out.println("Jedi's attack.");
        }
    }

    static class Luke extends Jedi {
        static void attack() {
            System.out.println("Luke's attack.");
        }
    }

    public static void main(String[] args) {
        Jedi jedi = new Luke();
        jedi.attack();
    }
}