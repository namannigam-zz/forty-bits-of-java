package com.stackoverflow.nullpointer.observable;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by naman.nigam on 28/09/15.
 */
abstract class Smoky implements Observer {

    Methy methy = new Methy();
    Messy messy = new Messy();


    public void iwant() {
        System.out.println("This is what I want to perform after each one of you.");
    }

    public void update(Observable o, Object arg) {
        System.out.println("Message board changed: " + arg);
    }

    public void smoke1() {
        System.out.println("Smoking the first part.");
        methy.method1();
        messy.messed3();
        messy.messed2();
        messy.messed4();
        methy.method4();
    }

    public void smoke2() {
        System.out.println("Smoking the second part.");
        methy.method2();
        methy.method1();
        methy.method1();
        methy.method4();
        messy.messed2();
        messy.messed4();
    }

    public void smoke3() {
        System.out.println("Smoking the second part.");
        methy.method2();
        messy.messed2();
        methy.method1();
        messy.messed1();
        methy.method4();
        messy.messed4();
        messy.messed3();
        methy.method3();
    }
}