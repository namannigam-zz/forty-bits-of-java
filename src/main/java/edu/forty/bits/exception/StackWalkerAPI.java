package edu.forty.bits.exception;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Created by naman.nigam on 11/08/17.
 */
public class StackWalkerAPI {

    public static void main(String[] args) {
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
        List<String> interestingClasses  = new ArrayList<>();
//        Optional<Class<?>> callerClass = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE).walk(s ->
//                s.map(StackWalker.StackFrame::getDeclaringClass)
//                        .filter(interestingClasses::contains)
//                        .findFirst());
//
//        Optional<Class<?>> frame = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE)
//                .walk((s) -> s.filter(f -> interestingClasses.contains(f.getDeclaringClass()))
//                    .map(StackWalker.StackFrame::getDeclaringClass)
//                    .findFirst());

        // 3 until current thread snapshot for the stack trace
        List<StackWalker.StackFrame> frameList = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE)
                .walk((s) -> s.collect(Collectors.toList()));


        // 4 get caller class from reflect equivalent
//        Optional<Class<?>> frames = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE)
//                .walk((s) -> s.map(StackWalker.StackFrame::getDeclaringClass).skip(2).findFirst());

    }
}