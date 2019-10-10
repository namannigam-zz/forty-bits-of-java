package edu.forty.bits.functional;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CustomCollectorImpl {

    public static void main(String[] args) {
        Map<String, List<String>> persons = new HashMap<>();
        Map<String, List<Long>> personLong = persons.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,
                entry -> entry.getValue().stream().map(Long::valueOf).collect(Collectors.toList())));

        List<String> cs = Arrays.asList("agent", "manager", "admin");
        List<String> interchanged = cs.stream()
                .map(c -> c.equals("manager") ? "agent" : c.equals("agent") ? "manager" : c)
                .collect(Collectors.toList());

        cs.replaceAll(s -> {
            if (s.equals("manager")) {
                return "agent";
            }
            if (s.equals("agent")) {
                return "manager";
            }
            return s;
        });

        cs.replaceAll(s -> s.replaceAll("agent|manager", replace(s)));


        List<Coordinates> coordinateList = new ArrayList<>();
        Map<String, List<Coordinates>> newList = coordinateList.stream().
                collect(Collectors.groupingBy(Coordinates::getName));
        List<Double> xData = coordinateList.stream()
                .map(Coordinates::getX)
                .collect(Collectors.toCollection(LinkedList::new));
        List<Double> yData = coordinateList.stream()
                .map(Coordinates::getY)
                .collect(Collectors.toCollection(LinkedList::new));


        List<List<Double>> xDatas = new ArrayList<>();
        List<List<Double>> yDatas = new ArrayList<>();
        newList.forEach((k, v) -> {
            xDatas.add(v.stream()
                    .map(Coordinates::getX)
                    .collect(Collectors.toCollection(LinkedList::new)));
            yDatas.add(v.stream()
                    .map(Coordinates::getY)
                    .collect(Collectors.toCollection(LinkedList::new)));
        });


        List<Offer> offers = Arrays.asList(new Offer(OfferType.STANDARD, BigDecimal.valueOf(10.0)),
                new Offer(OfferType.STANDARD, BigDecimal.valueOf(20.0)),
                new Offer(OfferType.STANDARD, BigDecimal.valueOf(30.0)),
                new Offer(OfferType.BONUS, BigDecimal.valueOf(5.0)),
                new Offer(OfferType.BONUS, BigDecimal.valueOf(5.0)));

        Comparator<Offer> compareLeastPrice = Comparator.comparing(Offer::getPrice);

        List<Offer> some = offers.stream()
                .filter(x -> x.getType() != OfferType.STANDARD)
                .collect(Collectors.toCollection(ArrayList::new));

        offers.stream()
                .filter(x -> x.getType() == OfferType.STANDARD)
                .min(Comparator.comparing(Offer::getPrice))
                .ifPresent(some::add);
    }


    public static Collector<Offer, ?, List<Offer>> minCollector() {
        class Acc {
            private Offer min = null;
            private List<Offer> result = new ArrayList<>();

            private void add(Offer offer) {
                if (offer.getType() == OfferType.STANDARD) {
                    if (min == null) {
                        min = offer;
                    } else {
                        min = offer.getPrice()
                                .compareTo(min.getPrice()) > 0 ? min : offer;
                    }
                } else {
                    result.add(offer);
                }
            }

            private Acc combine(Acc another) {
                result.addAll(another.result);
                return this;
            }

            private List<Offer> finisher() {
                result.add(min);
                return result;
            }
        }

        return Collector.of(Acc::new, Acc::add, Acc::combine, Acc::finisher);
    }

    private static String replace(String s) {
        return s.equals("manager") ? "agent" : s.equals("agent") ? "manager" : s;
    }


    public static class Coordinates {
        String name;
        Double x;
        Double y;

        Double getX() {
            return x;
        }

        Double getY() {
            return y;
        }

        String getName() {
            return name;
        }
    }

    public static class Offer {

        private final OfferType type;
        private final BigDecimal price;

        Offer(OfferType type, BigDecimal price) {
            this.type = type;
            this.price = price;
        }

        OfferType getType() {
            return type;
        }

        BigDecimal getPrice() {
            return price;
        }
    }

    public enum OfferType {
        STANDARD, BONUS
    }
}