package com.stackoverflow.nullpointer.collections;

import com.stackoverflow.nullpointer.pojo.Person;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ImmutableAndUnmodifiable {

    public static void main(String[] args) {

        List<Person> persons = Stream.of(new Person("stackoverflow")).collect(Collectors.toList());
        List<Person> unmodifiableList = List.copyOf(persons);
        List<Person> immutableList = persons.stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
        System.out.println(persons + "" + persons.size());
        System.out.println(unmodifiableList + "" + unmodifiableList.size());
        System.out.println(immutableList + "" + immutableList.size());

        persons.add(new Person("com/stackoverflow/nullpointer"));
        System.out.println(persons + "" + persons.size());
        System.out.println(unmodifiableList + "" + unmodifiableList.size());
        System.out.println(immutableList + "" + immutableList.size());

        immutableList.add(new Person("nmn"));
        unmodifiableList.add(new Person("nmn"));
    }
}