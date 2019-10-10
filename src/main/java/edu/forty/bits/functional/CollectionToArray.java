package com.stackoverflow.nullpointer.functional;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class CollectionToArray {

    public static void main(String[] args) {
        Collection<Foo> fooCollection = List.of(new Foo("food"), new Foo("fool"));
        Foo[] resultBeforeJDK11 = fooCollection.toArray(new Foo[0]);
        Foo[] resultAfterJDK11 = fooCollection.toArray(Foo[]::new);
        System.out.println(Arrays.toString(resultAfterJDK11) + Arrays.toString(resultBeforeJDK11));

        Collection<Bar> barCollection = Set.of(new Bar("cheers"), new Bar("to all"));
        Foo[] result = barCollection.stream().map(Foo::new).toArray(Foo[]::new);
        System.out.println(Arrays.toString(result));
    }

    @Getter
    public static class Foo {
        Bar bar;
        String fooVal;

        Foo(String fooVal) {
            this.fooVal = fooVal;
        }

        Foo(Bar bar) {
            this.bar = bar;
            System.out.println("Inside the RESTRO!");
        }
    }

    @AllArgsConstructor
    public static class Bar {
        String var;
    }
}