package com.stackoverflow.nullpointer.findings;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @see <href>https://stackoverflow.com/questions/48227496</href>
 * error: reference to ok is ambiguous
 * return ok(() -> System.out.append("aaa"));
 *         ^
 * both method <T#1>ok(Supplier<T#1>) in Q48227496 and method <T#2>ok(Procedure) in Q48227496 match
 * where T#1,T#2 are type-variables:
 * T#1 extends Object declared in method <T#1>ok(Supplier<T#1>)
 * T#2 extends Object declared in method <T#2>ok(Procedure)
 */
public class Q48227496_FixedInJv11 {

    //uncomment the below
//    public A<?> test() {
//        return ok(() -> System.out.append("aaa"));
//    }

    private class A<T> {
    }

    private <T> A<T> ok(java.util.function.Supplier<T> action) {
        return new A<>();
    }

    public <T> A<T> ok(T body) {
        return new A<>();
    }

    private <T> A<T> ok(Procedure action) {
        return new A<>();
    }

    public <T> A<T> ok() {
        return new A<>();
    }

    @FunctionalInterface
    public interface Procedure {
        void invoke();
    }

    // <href>https://bugs.java.com/bugdatabase/view_bug.do?bug_id=JDK-8195598</href>

    public static class CollectorsTeeing {

        public static void main(String[] args) {
            Function<BigDecimal, BigDecimal> func1 = x -> x;
            Function<BigDecimal, BigDecimal> func2 = y -> y;
            Map<Integer, BigDecimal> data = new HashMap<>();

            Map.Entry<Map<Integer, BigDecimal>, List<BigDecimal>> result = data.entrySet().stream()
                    .collect(Collectors.teeing(
                            Collectors.toMap(
                                    Map.Entry::getKey,
                                    i -> func1.apply(i.getValue())),
                            Collectors.mapping(
                                    i -> func1.andThen(func2).apply(i.getValue()),
                                    Collectors.toList()),
                            Map::entry));
        }

        public static <T, A1, A2, R1, R2, R> Collector<T, ?, R> teeing(
                Collector<? super T, A1, R1> downstream1,
                Collector<? super T, A2, R2> downstream2,
                BiFunction<? super R1, ? super R2, R> merger) {

            class Acc {
                A1 acc1 = downstream1.supplier().get();
                A2 acc2 = downstream2.supplier().get();

                void accumulate(T t) {
                    downstream1.accumulator().accept(acc1, t);
                    downstream2.accumulator().accept(acc2, t);
                }

                Acc combine(Acc other) {
                    acc1 = downstream1.combiner().apply(acc1, other.acc1);
                    acc2 = downstream2.combiner().apply(acc2, other.acc2);
                    return this;
                }

                R applyMerger() {
                    R1 r1 = downstream1.finisher().apply(acc1);
                    R2 r2 = downstream2.finisher().apply(acc2);
                    return merger.apply(r1, r2);
                }
            }

            return Collector.of(Acc::new, Acc::accumulate, Acc::combine, Acc::applyMerger);
        }
    }
}