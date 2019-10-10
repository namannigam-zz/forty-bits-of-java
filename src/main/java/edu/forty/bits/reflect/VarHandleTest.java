package com.stackoverflow.nullpointer.reflect;

import com.stackoverflow.nullpointer.interfaces.Question;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.invoke.VarHandle;

public class VarHandleTest {
    public static void main(String[] args) throws Throwable {


        //        such lookup to obtain a VarHandle for a field named i of type int on a receiver class Foo might be performed as follows:
        VarHandle fieldHandle = MethodHandles.lookup().
                in(Question.class).
                findVarHandle(Question.class, "votes", int.class);


        //        a VarHandle to an array of int may be created as follows:
        VarHandle intArrayHandle = MethodHandles.arrayElementVarHandle(int[].class);


        //        a VarHandle to view an array of byte as an unaligned array of long may be created as follows:
        VarHandle longArrayViewHandle = MethodHandles.byteArrayViewVarHandle(
                long[].class, java.nio.ByteOrder.BIG_ENDIAN);

        //        to produce a MethodHandle to the "compareAndSet" access mode for a particular variable kind and type:
        Question q = new Question();
        MethodHandle mhToVhCompareAndSet = MethodHandles.publicLookup().findVirtual(
                VarHandle.class,
                "compareAndSet",
                MethodType.methodType(boolean.class, Question.class, int.class, int.class));

        //        The MethodHandle can then be invoked with a variable kind and type compatible VarHandle instance as the first parameter:
        boolean r = (boolean) mhToVhCompareAndSet.invokeExact(fieldHandle, q, 0, 1);


        //        Such a MethodHandle lookup using findVirtual will perform an asType transformation to adjust arguments and return values.
        MethodHandle mhToVhCompareAndSet2 = MethodHandles.varHandleExactInvoker(
                VarHandle.AccessMode.COMPARE_AND_SET,
                MethodType.methodType(boolean.class, Question.class, int.class, int.class));

        boolean r1 = (boolean) mhToVhCompareAndSet2.invokeExact(fieldHandle, q, 0, 1);

    }
}
