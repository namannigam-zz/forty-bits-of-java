package edu.forty.bits.utilities;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created by naman.nigam on 23/03/17.
 */
public class CompareAndSwap {

    static Unsafe UNSAFE = getUnsafe();

    public static void main(String[] args) throws NoSuchFieldException, SecurityException {

        Holder h = new Holder();
        h.setValue(33);
        Class<?> holderClass = Holder.class;
        long valueOffset = UNSAFE.objectFieldOffset(holderClass.getDeclaredField("value"));
        int result = 0;
        for (int i = 0; i < 30_000; ++i) {
            result = strong(h, valueOffset);
        }
        System.out.println(result);

    }

    private static int strong(Holder h, long offset) {
        int sum = 0;
        for (int i = 33; i < 11_000; ++i) {
            boolean result = UNSAFE.compareAndSwapInt(h, offset, i, i + 1);
            if (!result) {
                sum++;
            }
        }
        return sum;
    }

    public static class Holder {
        private int value;

        void setValue(int value) {
            this.value = value;
        }
    }

    private static Unsafe getUnsafe() {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            return (Unsafe) f.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}