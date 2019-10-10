package com.stackoverflow.nullpointer.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupByParentChild {

    public static void main(String[] args) {
        List<A> aList = new ArrayList<>();
        Map<Integer,A> map = aList.stream().collect(Collectors.toMap(a -> a.getSomeB().getId(), Function.identity()));

    }

    public static class B {
        Integer id;
        String some;
        String some2;

        public Integer getId() {
            return id;
        }

        public String getSome() {
            return some;
        }

        public String getSome2() {
            return some2;
        }
    }

    public static class A {
        Integer id;
        B someB;
        String name;

        public Integer getId() {
            return id;
        }

        public B getSomeB() {
            return someB;
        }

        public String getName() {
            return name;
        }
    }

}