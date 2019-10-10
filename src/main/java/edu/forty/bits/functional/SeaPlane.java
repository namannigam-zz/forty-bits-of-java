package edu.forty.bits.functional;

class SeaPlane extends Vehicle implements FastFly, Sail {
    public void cruise() {
        System.out.println("SeaPlane :: cruise");
        FastFly.super.cruise(); // super used for default method
    }
}
