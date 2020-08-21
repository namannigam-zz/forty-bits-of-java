package edu.forty.bits.utilities;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PairPriorityQueue<E> {
    private final PriorityQueue<E> priorityQueue;
    private final Comparator<? super E> comparator;

    public PairPriorityQueue(final Comparator<? super E> comparator) {
        super();
        if (comparator == null) {
            throw new NullPointerException("Comparator is null.");
        }
        this.priorityQueue = new PriorityQueue<>(1, comparator);
        this.comparator = comparator;
    }

    public void add(final E e) {
        if (e == null) {
            throw new NullPointerException("e is null.");
        }
        if (priorityQueue.size() >= 2) {
            final E firstElm = priorityQueue.peek();
            if (comparator.compare(e, firstElm) < 1) {
                return;
            } else {
                priorityQueue.poll();
            }
        }
        priorityQueue.add(e);
    }

    public PriorityQueue<E> get() {
        return this.priorityQueue;
    }
}