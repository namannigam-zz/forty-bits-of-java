package edu.forty.bits.functional;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExtractSimilarAttributesFromEntity {
    protected String toCombinedString(SomeClass shipment) {
        return Optional.ofNullable(shipment)
                .map(SomeClass::getBill)
                .map(bill -> extractAttributes(bill, Bill::getNumberString, Bill::getPrefixString))
                .orElse(null);
    }

    @SafeVarargs
    private String extractAttributes(Bill entity, Function<Bill, String>... mappers) {
        List<String> attributes = Arrays.stream(mappers)
                .map(function -> function.apply(entity))
                .collect(Collectors.toList());
        return attributes.stream().anyMatch(s -> s == null || s.isEmpty()) ?
                null : String.join("-", attributes);
    }


    @SafeVarargs
    private <T, R> Stream<R> extractAttributes(T entity, Function<T, R>... mappers) {
        List<R> attributes = Arrays.stream(mappers)
                .map(function -> function.apply(entity))
                .collect(Collectors.toList());
        return attributes.stream().anyMatch(Objects::isNull) ?
                Stream.empty() : attributes.stream();
    }


    @Getter
    static class SomeClass {
        Bill bill;
    }

    @Getter
    static class Bill {
        String prefixString;
        String numberString;
    }
}