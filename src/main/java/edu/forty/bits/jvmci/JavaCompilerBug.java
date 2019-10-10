package edu.forty.bits.jvmci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class JavaCompilerBug {

    public static void main(String[] args) {
        List<String> vals = Arrays.asList("1", "2", "3");

        List<Foo> foos = map(vals, s -> Foo.with(last(vals)));
    }

    public static class Foo {
        public static Foo with(String value) {
            return new Foo();
        }

        public static Foo with(Foo value) {
            return new Foo();
        }
    }

    public static <A, B> List<B> map(List<A> input, Function<A, B> function) {
        List<B> ret = new ArrayList<>();
        for (A element : input) {
            ret.add(function.apply(element));
        }
        return ret;
    }

    public static <T> T last(List<T> c) {
        return c.get(c.size() - 1);

    }
}