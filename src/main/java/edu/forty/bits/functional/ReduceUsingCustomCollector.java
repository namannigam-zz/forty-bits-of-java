package edu.forty.bits.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class ReduceUsingCustomCollector {

    public static void main(String[] args) {
        List<List<Integer>> result = Stream.of(1, 2, 3, 4, 2, 8)
                .collect(Collector.of(
                        ArrayList::new,
                        (list, elem) -> {
                            if (list.isEmpty()) {
                                List<Integer> inner = new ArrayList<>();
                                inner.add(elem);
                                list.add(inner);
                            } else {
                                if (elem == 2) {
                                    list.add(new ArrayList<>());
                                } else {
                                    List<Integer> last = list.get(list.size() - 1);
                                    last.add(elem);
                                }
                            }
                        },
                        (left, right) -> {
                            // This is the real question here:
                            // can left or right be empty here?
                            return left;
                        }));
    }
}
