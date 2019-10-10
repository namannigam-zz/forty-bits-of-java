package com.stackoverflow.nullpointer.functional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MergeMapsBasedOnCondition {

    public static void main(String[] args) {
        Map<String, Discount> prepaid = new HashMap<String, Discount>();
        prepaid.put("HAPPY50", new Discount(100, "M1"));
        prepaid.put("LUCKY10", new Discount(10, "M2"));
        prepaid.put("FIRSTPAY", new Discount(20, "M3"));

        Map<String, Discount> otherBills = new HashMap<String, Discount>();
        otherBills.put("HAPPY50", new Discount(60, "M4"));
        otherBills.put("LUCKY10", new Discount(7, "M5"));
        otherBills.put("GOOD", new Discount(20, "M6"));

        Map<String, Discount> finalMap = new HashMap<>();
        otherBills.forEach((k, v) -> finalMap.merge(k, v, (discountFromPrepaid, discountFromOtherBill) -> finalMap.put(k,
                new Discount(prepaid.get(k).getAmount() + v.getAmount(), v.getLastMarketingRegion()))));


        List<Map<String, Discount>> discList = new ArrayList<>();
        discList.add(prepaid);
        discList.add(otherBills);


        Map<String, Discount> result = discList.stream()
                .flatMap(m -> m.entrySet().stream())
                .collect(
                        Collectors.groupingBy(Map.Entry::getKey,
                                Collectors.mapping(Map.Entry::getValue,
                                        Collectors.reducing(new Discount(0, "Invalid"),
                                                (o1, o2) -> new Discount(o1.getAmount() + o2.getAmount(), o2.getLastMarketingRegion())))));
    }

    public static class Discount {
        int amount;
        String lastMarketingRegion;

        Discount(int amount, String lastMarketingRegion) {
            this.amount = amount;
            this.lastMarketingRegion = lastMarketingRegion;
        }

        public int getAmount() {
            return amount;
        }

        public String getLastMarketingRegion() {
            return lastMarketingRegion;
        }

        public String toString() {
            return String.format("{%s,\"%s\"}", amount, lastMarketingRegion);
        }
    }
}