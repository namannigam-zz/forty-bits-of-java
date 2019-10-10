package edu.forty.bits.intrface;

public interface SubInt extends SuperInt {
    @Override
    default void method3() {  //  compile time error
        System.out.println("Inside SubInt");
    }
}