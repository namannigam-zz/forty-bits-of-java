package edu.forty.bits.functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaVsIteration {

    static void lambdaMagic() {
        List<String> stringList = new ArrayList<>();
        stringList.add("add");
        stringList.add("subtract");
        stringList.add("multiply");
        stringList.add("divide");

        // deprecated
        for (String aStringList : stringList) {
            System.out.println(aStringList);
        }
        // optimised
        stringList.forEach(System.out::println);

        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5);

        // deprecated
        int total = 0;
        for (int e : values) {
            total += e * 2;
        }
        System.out.println(total);

        // lambda used - mapping operation
        System.out.println(values.stream().map(e -> e * 2).reduce(0, (c, e) -> c + e));
    }

    public static void main(String[] args) {
        lambdaMagic();
    }
}