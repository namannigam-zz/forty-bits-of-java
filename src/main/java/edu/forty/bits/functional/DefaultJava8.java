package edu.forty.bits.functional;

public class DefaultJava8 {

    public void use() {
        SeaPlane seaPlane = new SeaPlane();
        seaPlane.takeOff();
        seaPlane.turn();
        seaPlane.cruise();
        seaPlane.land(); // Method in class hierarchy rules

    }

    public static void main(String[] args) {
        new DefaultJava8().use();
        System.out.println("Hey!");
    }

}