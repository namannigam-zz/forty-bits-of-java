package edu.forty.bits.features.records.pattern;

import java.util.Objects;

public class Id {

    public static final Id NULL_ID = new Id();

    private String id;

    public Id(String id) {
        this.id = Objects.requireNonNull(id);
    }

    private Id() {}
}