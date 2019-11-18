package edu.forty.bits.functional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamMapAndReduce {

    public static DummyObject main(String[] args) {
        List<Dummy> dummy =new ArrayList<>();
        List<NewDummy> newDummyList = dummy.stream().map(StreamMapAndReduce::convertDummyToNewDummy).collect(Collectors.toList());

        if(true) {
            BigDecimal amount1 = BigDecimal.ZERO;
            for (Dummy eachDummy : dummy) {
                if (Optional.ofNullable(eachDummy.getAmount1()).isPresent()) {
                    BigDecimal dummy1Amount1 = eachDummy.getAmount1();
                    amount1 = amount1.add(dummy1Amount1);
                }
            }
            BigDecimal amount2 = BigDecimal.ZERO;
            for (Dummy eachDummy : dummy) {
                if (Optional.ofNullable(eachDummy.getAmount2()).isPresent()) {
                    BigDecimal dummy1Amount2 = eachDummy.getAmount2();
                    amount2 = amount2.add(dummy1Amount2);
                }
            }

            return new DummyObject(newDummyList, amount1, amount2);
        } else {
            return new DummyObject(newDummyList);
        }
    }

    private static NewDummy convertDummyToNewDummy(Dummy dummy){
        return new NewDummy();
    }

    private static class Dummy {
        BigDecimal amount1;
        BigDecimal amount2;

        public BigDecimal getAmount1() {
            return amount1;
        }

        public BigDecimal getAmount2() {
            return amount2;
        }
    }

    private static class NewDummy {

    }

    private static class DummyObject {
        List<NewDummy> newDummies;
        BigDecimal amount1;
        BigDecimal amount2;

        public DummyObject(List<NewDummy> newDummies) {
            this.newDummies = newDummies;
        }

        public DummyObject(List<NewDummy> newDummies, BigDecimal amount1, BigDecimal amount2) {
            this.newDummies = newDummies;
            this.amount1 = amount1;
            this.amount2 = amount2;
        }
    }
}

