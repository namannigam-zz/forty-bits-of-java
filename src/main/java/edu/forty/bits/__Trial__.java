package edu.forty.bits;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.*;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class __Trial__ {

    public static void main(String[] args) {
        List<Summary> statuses = List.of(
                new Summary(LocalDate.now(), Status.ACCEPTED, 1),
                new Summary(LocalDate.now(), Status.FAILED, 40),
                new Summary(LocalDate.now().plusDays(3), Status.ACCEPTED, 10),
                new Summary(LocalDate.now().plusDays(3), Status.REJECTED, 15));

        Map<LocalDate, Map<Status, Summary>> lookup = statuses.stream()
                .collect(Collectors.groupingBy(Summary::getDate,
                        Collectors.toMap(Summary::getStatus, Function.identity())));

        List<Summary> overallResult = lookup.entrySet().stream()
                .flatMap(en -> EnumSet.allOf(Status.class).stream()
                        .map(status -> en.getValue().containsKey(status) ?
                                en.getValue().get(status) : Summary.builder()
                                .date(en.getKey()).status(status).count(0).build()))
                .collect(Collectors.toList());
        overallResult.stream().map(Objects::toString).forEach(System.out::println);
    }

    enum Status {
        ACCEPTED("Accepted"),
        REJECTED("Rejected"),
        FAILED("Failed");

        private final String label;

        Status(final String label) {
            this.label = label;
        }
    }

    @Getter
    static class Nice {
        private boolean prop;
    }

    @Getter
    @AllArgsConstructor
    @ToString
    @Builder
    static class Summary {
        private LocalDate date;
        private Status status;
        private int count;

    }
}