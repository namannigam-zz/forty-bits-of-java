package edu.forty.bits.functional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectorsToMapOrGrouping {

    class Numbers {
        private Long userId;
        private Long number1;
        private Long number2;

        public Long getUserId() {
            return userId;
        }

        public Long getNumber1() {
            return number1;
        }

        public Long getNumber2() {
            return number2;
        }
    }

    public static void main(String[] args) {
        List<Numbers> numbers = new ArrayList<>();
        Map<Long, Long> all = new HashMap<>();
        for (Numbers number : numbers) {
            if (all.containsKey(number.getNumber1())) {
                long value = all.get(number.getUserId());
                value += (number.getNumber1() + number.getNumber2());
                all.put(number.getUserId(), value);
            } else {
                all.put(number.getUserId(), number.getNumber1() + number.getNumber2());
            }
        }

        numbers.forEach(x -> all.merge(x.getUserId(),
                x.getNumber1() + x.getNumber2(), (oldV, newV) -> oldV + newV));

    }
}