package edu.forty.bits.inheritence;

public class ConsA {

    public ConsA() {
        System.out.println("A");
        h();
    }

    public void h() {
        String className = this.getClass().getName();
        System.out.println(className);
    }
}