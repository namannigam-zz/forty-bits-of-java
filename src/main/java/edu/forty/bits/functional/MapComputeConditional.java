package edu.forty.bits.functional;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class MapComputeConditional {

    public static void main(String[] args) {
        Map<String, Float> someHashMap = new HashMap<>();
        String preEvalObj = new String("123");
        someHashMap.forEach((key, value) -> {
            if (preEvalObj.equals(key)) {
                someOpsOnValue();
            } else {
                someOtherOpsOnValue();
            }
        });

        BiConsumer<String, Float> biConsumer = (key, value) -> {
            if (key.equals("123")) {
                someOpsOnValue();
            } else {
                someOtherOpsOnValue();
            }
        };

        someHashMap.forEach(biConsumer);

    }


    static void someOpsOnValue() {

    }

    static void someOtherOpsOnValue() {

    }
}
