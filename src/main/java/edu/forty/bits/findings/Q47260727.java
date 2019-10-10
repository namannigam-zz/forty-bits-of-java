package edu.forty.bits.findings;

import java.net.UnknownHostException;

/**
 * @see <href>https://stackoverflow.com/questions/47260727/</href>
 */
public class Q47260727 {

    @FunctionalInterface
    public interface Closure<R> {
        R apply();
    }

    @FunctionalInterface
    public interface VoidClosure {
        void apply();
    }

    private static <R> R call(Closure<R> closure) {
        return closure.apply();
    }

    private static void call(VoidClosure closure) throws UnknownHostException {
        call(() -> {
            closure.apply();
            return null;
        });
    }

    private static <T> void myMethod(Object data) {
        System.out.println(data);
    }

    public static void main(String[] args) {
//        call(() -> myMethod("hello")); //compile error in jdk9
    }

    // @see <href>http://bugs.java.com/bugdatabase/view_bug.do?bug_id=JDK-8191290</href>
}