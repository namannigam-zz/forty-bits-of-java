package com.stackoverflow.nullpointer.clazz;

import java.util.Arrays;
import java.util.List;

public class Nestmate {

    public static void main(String[] args) {
        System.out.println(Entity.class.isNestmateOf(Entity.class));
        System.out.println(Entity.class.isNestmateOf(Entity.InnerEntity.class));
        System.out.println(Entity.class.isNestmateOf(Entity.AnotherInnerEntity.class));
        System.out.println(Entity.InnerEntity.class.isNestmateOf(Entity.AnotherInnerEntity.class));
        System.out.println(List.class.getNestHost());
        System.out.println(Arrays.class.getNestHost());
    }
}