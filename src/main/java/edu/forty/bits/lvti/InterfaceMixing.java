package com.stackoverflow.nullpointer.lvti;

public class InterfaceMixing {

    public static void main(String... args) {
        var duck = (Quacks & Waddles) Mixin::create;
        duck.quack();
        duck.waddle();
    }

    interface Quacks extends Mixin {
        default void quack() {
            System.out.println("Quack");
        }
    }

    interface Waddles extends Mixin {
        default void waddle() {
            System.out.println("Waddle");
        }
    }

    interface Mixin {
        void __noop__();

        static void create() {
        }
    }

    /**
     * An alternate implementation to the intersection type
     */
    public static <Duck extends Quacks & Waddles> void use(Duck duck) {
        duck.quack();
        duck.waddle();
        duck.__noop__();
    }

}