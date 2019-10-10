package com.stackoverflow.nullpointer.function;

import java.io.Serializable;
import java.util.Objects;
import java.util.function.Function;

public class ComplexFunctions {

    private static <A, B, C> Function<A, C> compose(final Function<? super B, ? extends C> g, final Function<? super A, ? extends B> f) {
        return new FunctionComposition<A, B, C>(g, f);
    }

    private static <A, B, C, D> Function<A, D> compose(final Function<? super C, ? extends D> f1,
                                                       final Function<? super B, ? extends C> f2, final Function<? super A, ? extends B> f3) {
        return new FunctionComposition<>(f1, compose(f2, f3));
    }

    private static <A, B, C, D, E> Function<A, E> compose(final Function<? super D, ? extends E> f4,
                                                          final Function<? super C, ? extends D> f3, final Function<? super B, ? extends C> f2,
                                                          final Function<? super A, ? extends B> f1) {
        return compose(f4, compose(f3, f2, f1));
    }

    public static <A, B, C, D, E, F> Function<A, F> compose(final Function<? super E, ? extends F> f5,
                                                            final Function<? super D, ? extends E> f4, final Function<? super C, ? extends D> f3,
                                                            final Function<? super B, ? extends C> f2, final Function<? super A, ? extends B> f1) {
        return compose(f5, compose(f4, f3, f2, f1));
    }

    public static class FunctionComposition<A, B, C> implements Function<A, C>, Serializable {

        private static final long serialVersionUID = 1;

        private final Function<? super B, ? extends C> g;
        private final Function<? super A, ? extends B> f;

        FunctionComposition(Function<? super B, ? extends C> g, Function<? super A, ? extends B> f) {
            this.g = Objects.requireNonNull(g);
            this.f = Objects.requireNonNull(f);
        }

        @Override
        public C apply(A a) {
            return g.apply(f.apply(a));
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof FunctionComposition) {
                FunctionComposition<?, ?, ?> that = (FunctionComposition<?, ?, ?>) obj;
                return f.equals(that.f) && g.equals(that.g);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(getClass(), f, g);
        }

        @Override
        public String toString() {
            return g + "(" + f + ")";
        }
    }
}