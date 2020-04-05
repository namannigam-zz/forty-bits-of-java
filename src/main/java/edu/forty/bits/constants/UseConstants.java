package edu.forty.bits.constants;

import java.lang.invoke.MethodHandles;

public class UseConstants {

    // when does it make sense to implement Constable and not ConstantDesc?
    // what's a practical use of these interfaces?
    // design - why are these two separate interfaces (related to first closely)?
    public static void main(String[] args) throws ReflectiveOperationException {
        Integer integer = Integer.MAX_VALUE;
        System.out.println(integer.describeConstable());
        System.out.println(integer.resolveConstantDesc(MethodHandles.lookup()));
        Memory memory = new Memory(1);
        System.out.println(memory.describeConstable());
        System.out.println(memory.resolveConstantDesc(MethodHandles.publicLookup()));
    }
}
