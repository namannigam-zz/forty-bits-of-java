package edu.forty.bits.observable;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by naman.nigam on 28/09/15.
 */
public class Methy extends Observable {
    private String message;

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
    }

    @Override
    public void notifyObservers(Object arg) {
        super.notifyObservers(arg);
    }

    @Override
    public synchronized boolean hasChanged() {
        return super.hasChanged();
    }

    @Override
    public void notifyObservers() {
        super.notifyObservers();
    }

    @Override
    public synchronized int countObservers() {
        return super.countObservers();
    }

    @Override
    public synchronized void deleteObserver(Observer o) {
        super.deleteObserver(o);
    }

    @Override
    public synchronized void deleteObservers() {
        super.deleteObservers();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }


    public String getMessage() {
        return message;
    }

    public void changeMessage(String message) {
        this.message = message;
        setChanged();
        notifyObservers(message);
    }


    public static void main(String[] args) {
        Methy methy = new Methy();
        Smoky smoke = new Smoky() {
            @Override
            public void smoke1() {
                super.smoke1();
            }
        };
        methy.addObserver(smoke);
        methy.changeMessage("This has something to do with the observer.");
    }


    public void method1() {
        System.out.println("Recalling something from first part.");
    }

    public void method2() {
        System.out.println("Recalling something from second part.");
    }

    public void method3() {
        System.out.println("Recalling something from third part.");
    }

    public void method4() {
        System.out.println("Recalling something from fourth part.");
    }
}