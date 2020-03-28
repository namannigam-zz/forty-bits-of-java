package edu.forty.bits.functional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomMethodInvocation {

    public void meth1() {
        System.out.println("one");
    }

    public void meth2() {
        System.out.println("two");
    }

    public void meth3() {
        System.out.println("three");
    }

    public void meth4() {
        System.out.println("four");
    }

    public void meth5() {
        System.out.println("five");
    }

    public static void main(String[] args) {
        RandomMethodInvocation scratch = new RandomMethodInvocation();

        //using runnable
        List<Runnable> runnableList = Arrays.asList(scratch::meth1, scratch::meth2,
                scratch::meth3, scratch::meth4, scratch::meth5);
        Collections.shuffle(runnableList);
        runnableList.iterator().next().run();

        // using switch
        int randomNumber = new Random().nextInt(5);
        switch (randomNumber) {
            case 0 -> scratch.meth1();
            case 1 -> scratch.meth2();
            case 2 -> scratch.meth3();
            case 3 -> scratch.meth4();
            case 4 -> scratch.meth5();
            default -> throw new IllegalArgumentException();
        }
    }
}