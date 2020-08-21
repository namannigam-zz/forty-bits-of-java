package edu.forty.bits.gc;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public class PhantomReferencesEnqueued {

    public static void main(String[] args) throws IllegalArgumentException {
        ReferenceQueue<Object> queue = new ReferenceQueue<Object>();
        Reference<Object> reference = newReference(newHugeObject(), queue);
        Object huge = newHugeObject();
        drainReferences(queue);
        System.out.println(" ok ");
    }

    private static void drainReferences(ReferenceQueue<Object> queue) {
        Reference<?> ref;
        while ((ref = queue.poll()) != null) {
            ref.clear();
        }
    }

    private static <T> Reference<T> newReference(T referent, ReferenceQueue<? super T> queue) {
        Reference<T> reference = new PhantomReference<T>(referent, queue);
//        Reference<T> reference = new SoftReference<T>(referent, queue);
//        Reference<T> reference = new WeakReference<T>(referent, queue);
        return reference;
    }

    private static Object newHugeObject() {
        int size = (int) (Runtime.getRuntime().maxMemory() * 2 / 3);
        return new byte[size];
    }
}