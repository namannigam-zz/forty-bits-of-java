package edu.forty.bits.collections;

import edu.forty.bits.Objects;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ImmutableAndUnmodifiable {

    public static void main(String[] args) {

        List<Objects.Person> persons = Stream.of(new Objects.Person("stackoverflow")).collect(Collectors.toList());
        List<Objects.Person> unmodifiableList = List.copyOf(persons);
        List<Objects.Person> immutableList = persons.stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
        System.out.println(persons + "" + persons.size());
        System.out.println(unmodifiableList + "" + unmodifiableList.size());
        System.out.println(immutableList + "" + immutableList.size());

        persons.add(new Objects.Person("com/stackoverflow/nullpointer"));
        System.out.println(persons + "" + persons.size());
        System.out.println(unmodifiableList + "" + unmodifiableList.size());
        System.out.println(immutableList + "" + immutableList.size());

        immutableList.add(new Objects.Person("nmn"));
        unmodifiableList.add(new Objects.Person("nmn"));
    }
}