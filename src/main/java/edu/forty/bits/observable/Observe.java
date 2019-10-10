package edu.forty.bits.observable;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by naman.nigam on 28/09/15.
 */
public class Observe extends Observable {
    private String message;

    public String getMessage() {
        return message;
    }

    public void changeMessage(String message) {
        this.message = message;
        setChanged();
        notifyObservers(message);
    }

    public static void main(String[] args) {
        Observe board = new Observe();
        Student bob = new Student();
        Student joe = new Student();
        board.addObserver(bob);
        board.addObserver(joe);
        board.changeMessage("More Homework!");
    }

    static class Student implements Observer {
        public void update(Observable o, Object arg) {
            System.out.println("Message board changed: " + arg);
        }
    }
}