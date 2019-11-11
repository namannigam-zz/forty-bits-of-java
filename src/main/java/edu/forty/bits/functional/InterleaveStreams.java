package edu.forty.bits.functional;

import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class InterleaveStreams {

    // Modified version of and answer to https://stackoverflow.com/questions/53307682/how-to-interleave-merge-two-java-8-streams
    public static <T> Stream<T> interleave(Stream<? extends T> a, Stream<? extends T> b) {
        Spliterator<? extends T> spA = a.spliterator();
        Spliterator<? extends T> spB = b.spliterator();
        long s = spA.estimateSize() + spB.estimateSize();
        if (s < 0) s = Long.MAX_VALUE;
        int ch = spA.characteristics() & spB.characteristics()
                & (Spliterator.NONNULL | Spliterator.SIZED);
        ch |= Spliterator.ORDERED;

        return StreamSupport.stream(new Spliterators.AbstractSpliterator<>(s, ch) {
            Spliterator<? extends T> sp1 = spA;
            Spliterator<? extends T> sp2 = spB;

            @Override
            public boolean tryAdvance(Consumer<? super T> action) {
                Spliterator<? extends T> sp = sp1;
                if (sp.tryAdvance(action)) {
                    sp1 = sp2;
                    sp2 = sp;
                    return true;
                }
                return sp2.tryAdvance(action);
            }
        }, false);
    }
}