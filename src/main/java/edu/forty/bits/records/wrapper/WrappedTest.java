package edu.forty.bits.records.wrapper;

import java.util.Arrays;

public class WrappedTest {

    public static void main(String[] args) {
        var ints = new int[]{1, 2};

        var foo = new Foo(ints);
        System.out.println(foo); // Foo[ints=[I@6433a2]
        System.out.println(new Foo(new int[]{1,2}).equals(new Foo(new int[]{1,2}))); // false
        System.out.println(new Foo(ints).equals(new Foo(ints))); //true
        System.out.println(foo.equals(foo)); // true

        var bar = new Bar(ints);
        System.out.println(bar); // Bar{arr=[1, 2]}
        System.out.println(new Bar(new int[]{1,2}).equals(new Bar(new int[]{1,2}))); // true
        System.out.println(new Bar(ints).equals(new Bar(ints))); //true
        System.out.println(bar.equals(bar)); // true

        var integers = Arrays.asList(1, 2);
        var world =  new World(integers);
        System.out.println(world); // World{ints=[1, 2]}
        System.out.println(new World(Arrays.asList(1, 2)).equals(new World(Arrays.asList(1, 2)))); // true
        System.out.println(new World(integers).equals(new World(integers))); //true
        System.out.println(world.equals(world)); // true


        var worldRecord =  new WorldRecord(integers);
        System.out.println(worldRecord); // World{ints=[1, 2]}
        System.out.println(new WorldRecord(Arrays.asList(1, 2)).equals(new WorldRecord(Arrays.asList(1, 2)))); // true
        System.out.println(new WorldRecord(integers).equals(new WorldRecord(integers))); //true
        System.out.println(worldRecord.equals(worldRecord)); // true



    }
}
