package edu.forty.bits.features;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * https://openjdk.java.net/jeps/259
 */
public class StackWalkerAPI {

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

    public static void main(String[] args) {
        a();
        try {
            Method methodA = Class.forName("experiment.StackWalkerDemo").getMethod("a");
            methodA.invoke(null, (Object[]) null);
        } catch (Exception ex) {
            List<StackWalker.StackFrame> frames = StackWalker.getInstance().walk(s ->
                    s.dropWhile(f -> f.getClassName().startsWith("experiment."))
                            .limit(10)
                            .collect(Collectors.toList()));
            Logger.getLogger(StackWalkerAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void takeAWalk() {
        List<String> interestingClasses = new ArrayList<>();
        Optional<? extends Class<?>> callerClass = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE)
                .walk(s -> s.map(StackWalker.StackFrame::getDeclaringClass)
                        .filter(interestingClasses::contains)
                        .findFirst());

        Optional<? extends Class<?>> walk = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE)
                .walk(s -> s.filter(f -> interestingClasses.contains(f.getDeclaringClass()))
                        .map(StackWalker.StackFrame::getDeclaringClass)
                        .findFirst());

        // 3 until current thread snapshot for the stack trace
        List<StackWalker.StackFrame> frameList = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE)
                .walk(s -> s.collect(Collectors.toList()));


        // 4 get caller class from reflect equivalent
        Optional<? extends Class<?>> frames = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE)
                .walk(s -> s.map(StackWalker.StackFrame::getDeclaringClass).skip(2).findFirst());
    }


    //Stack walking without instantiating
    private StackWalker walker;

    public void init() {
        this.walker = StackWalker.getInstance();
    }

    public void walkTheStack() {
        this.walker.forEach(this::print);
    }

    private void print(StackWalker.StackFrame frame) {
        String className = frame.getClassName();
        String methodName = frame.getMethodName();
        int lineNumber = frame.getLineNumber();
        System.out.println(className + "." + methodName + ":" + lineNumber);
    }
}