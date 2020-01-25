package edu.forty.bits.records;

import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public final class Student {
    private final String name;
    private final int age;
    private final double timeSpent;
}