package com.stackoverflow.nullpointer.module;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class RunTemp {

    public static void main(String[] args) {
        class Person {
            private int age;

            public Person(int age) {
                this.age = age;
            }

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }
        }

        List<String> data = Arrays.asList("1", "2", "3");
        Stream<Person> stream = data.stream().map(Integer::valueOf).map(Person::new);

    }

}