package edu.forty.bits.reflection;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

public class VarHandleExample {
    public int publicTestVariable = 10;

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        VarHandleExample e = new VarHandleExample();
        System.out.println(e.publicTestVariable);
        e.update();
        System.out.println(e.publicTestVariable);


    }

    private void update() throws NoSuchFieldException, IllegalAccessException {
        VarHandle publicIntHandle = MethodHandles.lookup().in(String.class)
                .findVarHandle(VarHandleExample.class, "publicTestVariable", int.class);
        publicIntHandle.compareAndSet(this, 10, 100); // CAS
    }
}