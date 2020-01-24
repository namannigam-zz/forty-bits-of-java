package edu.forty.bits.functional;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// https://stackoverflow.com/questions/59883961
public interface ConsumerChaining<T> {

    Consumer<T> start();

    Consumer<T> performDailyAggregates();

    Consumer<T> performLastNDaysAggregates();

    Consumer<T> repopulateScores();

    Consumer<T> updateDataStore();

    private void performAllTasks(T data) {
        start().andThen(performDailyAggregates())
                .andThen(performLastNDaysAggregates())
                .andThen(repopulateScores())
                .andThen(updateDataStore())
                .accept(data);
    }

    default Consumer<T> NOOP() {
        return t -> {
        };
    }


    private void performAllTasks(Stream<Consumer<T>> consumerList, T data) {
        consumerList.reduce(NOOP(), Consumer::andThen).accept(data);
    }

    private void performAllTasks(List<Consumer<T>> consumerList, T data) {
        consumerList.stream().reduce(NOOP(), Consumer::andThen).accept(data);
    }

    private static <T> void performAllTasksOrdered(Stream<Consumer<T>> consumers, T data) {
        consumers.forEachOrdered(c -> c.accept(data));
    }

    int ITERATION_THRESHOLD = 16; // tune yourself

    static <T> Consumer<T> combineAllTasks(Stream<Consumer<T>> consumers) {
        List<Consumer<T>> consumerList = consumers.collect(Collectors.toList());
        if (consumerList.isEmpty()) return t -> {
        };
        if (consumerList.size() == 1) return consumerList.get(0);
        return consumerList.size() < ITERATION_THRESHOLD ?
                balancedReduce(consumerList, Consumer::andThen, 0, consumerList.size()) :
                (t -> consumerList.forEach(c -> c.accept(t)));
    }

    private static <T> T balancedReduce(List<T> l, BinaryOperator<T> f, int start, int end) {
        if (end - start > 2) {
            int mid = (start + end) >>> 1;
            return f.apply(balancedReduce(l, f, start, mid), balancedReduce(l, f, mid, end));
        }
        T t = l.get(start++);
        if (start < end) t = f.apply(t, l.get(start));
        assert start == end || start + 1 == end;
        return t;
    }
}