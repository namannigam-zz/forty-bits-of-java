package edu.forty.bits.constants;

import edu.forty.bits.__Trial__;

import java.lang.constant.ClassDesc;
import java.lang.constant.Constable;
import java.lang.constant.ConstantDesc;
import java.lang.constant.ConstantDescs;
import java.lang.invoke.MethodHandles;
import java.util.Optional;

public record Memory(int size) implements Constable, ConstantDesc {
    @Override
    public Optional<? extends ConstantDesc> describeConstable() {
        Optional.of(new ClassDesc() {
            @Override
            public String descriptorString() {
                return "Memory:= " + size;
            }

            @Override
            public Object resolveConstantDesc(MethodHandles.Lookup lookup) throws ReflectiveOperationException {
                return lookup.in(Memory.class).toString();
            }
        });
        Optional.of(ConstantDescs.CD_Class); // ClassDesc.of("java.lang.Class")
        return Optional.of(ConstantDescs.CD_long); //  ClassDesc.ofDescriptor("J")
    }

    @Override
    public Object resolveConstantDesc(MethodHandles.Lookup lookup) throws ReflectiveOperationException {
        return lookup.in(__Trial__.class).toString();
    }

    @Override
    public String toString() {
        return "Memory{" +
                "size=" + size +
                '}';
    }
}
