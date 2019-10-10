package edu.forty.bits.jdk09.challenges;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Challenge4 {

    static class Jedi {
        private String name;
        private int age;

        public Jedi(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        List<Jedi> jediList = List.of(new Jedi("Some", 10), new Jedi("Come", 12), new Jedi("True", 15));


        Map<Integer, List<Jedi>> jediByAge =
                jediList.stream().filter(j -> j.age < 10).collect(Collectors.groupingBy(j -> j.age));


        List<Jedi> newJediList = Optional.ofNullable(jediByAge.get(10)).orElse(List.of(new Jedi("False", 100)));


        System.out.println(newJediList.get(0).name);
    }
}