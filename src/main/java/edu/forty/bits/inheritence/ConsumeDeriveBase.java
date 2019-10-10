package edu.forty.bits.inheritence;

public class ConsumeDeriveBase {

    public static void main(String[] args) {
        Base base = new Base();
        Derive derive = new Derive();
        System.out.println(((Base)derive).className);
//        System.out.println(derive.className);
    }
}
