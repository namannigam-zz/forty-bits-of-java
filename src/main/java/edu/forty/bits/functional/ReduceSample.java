package edu.forty.bits.functional;

import java.util.Arrays;
import java.util.List;

public class ReduceSample {

    enum Direction { IN, OUT }

    class Tuple {
        Direction direction;
        int[] data;

        Tuple(Direction direction, int[] data) {
            this.direction = direction;
            this.data = data;
        }

        Direction getDirection() {
            return direction;
        }

        public int[] getData() {
            return data;
        }

        Tuple merge(Tuple t) {
            return new Tuple(direction, concat(getData(), t.getData()));
        }
    }

    private static int[] concat(int[] first, int[] second) {
        int[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }

    public static void main(String[] args) {
//        Stream<Tuple> tupleStream = Stream.of(new Tuple(Direction.IN,new int[]{1,2,});
//        List<Tuple> reduce = tupleStream.reduce(new ArrayList<>(), ReduceSample::add, ReduceSample::combine);
    }

    private static List<Tuple> combine(List<Tuple> list1, List<Tuple> list2) {
        System.out.println("combine");
        list1.addAll(list2);
        return list1;
    }

    private static List<Tuple> add(List<Tuple> list, Tuple t) {
        System.out.println("add");
        if (list.size() == 0) {
            list.add(t);
        } else {
            int lastIndex = list.size() - 1;
            Tuple last = list.get(lastIndex);
            if (last.getDirection() == t.getDirection()) {
                list.set(lastIndex, last.merge(t));
            } else {
                list.add(t);
            }
        }
        return list;
    }
}
