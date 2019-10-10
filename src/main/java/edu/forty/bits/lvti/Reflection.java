package edu.forty.bits.lvti;

public class Reflection {

    public static void main(String[] args) throws NoSuchMethodException {
        ClassLoader.class.getDeclaredMethod("defineClass", String.class, byte[].class, int.class, int.class);

//        new MethodHandles.Lookup(ClassLoader.class).defineClass();
    }
}
