package edu.forty.bits.exception;

import java.util.List;
import java.util.Set;

/**
 * Created by naman.nigam on 12/08/17.
 */
public class StackWalkerDemo {

    public static void a() {
        b();
    }

    static void b() {
        c();
    }

    static void c() {
        d();
    }

    static void d() {
        List<StackWalker> stackWalkers =
                List.of(StackWalker.getInstance(Set.of(StackWalker.Option.RETAIN_CLASS_REFERENCE)),
                        StackWalker.getInstance(Set.of(StackWalker.Option.SHOW_REFLECT_FRAMES)),
                        StackWalker.getInstance(Set.of(StackWalker.Option.SHOW_HIDDEN_FRAMES)));
        stackWalkers.forEach(stackWalker -> stackWalker.forEach(System.out::println));
    }
}