package edu.forty.bits.jdk09.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Challenge8 {

    public static void main(String[] args) throws Throwable {

        Integer[] recovery= new Integer[4];
        int[] periods =  new int[4];
        int[] deadlines =   new int[4];

        List<List<Integer>>temp= new ArrayList<>();

        temp.add(Arrays.stream(recovery).collect(Collectors.toList()));


        List<Corleone> corleoneList =
                List.of(new Corleone("Naman"), new Corleone("Nigam"), new Corleone("Neha"), new Corleone("Mishra"));

        corleoneList.stream().parallel().skip(4).limit(4).findFirst().ifPresent(System.out::println);
    }

    static class Corleone {
        private String name;

        public Corleone(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }
}