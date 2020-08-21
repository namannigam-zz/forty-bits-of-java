package edu.forty.bits.features.records.pattern;

import java.util.Objects;

public record IdRecord(String id) {
    public static final IdRecord NULL_ID = new IdRecord();

    public IdRecord() {
        this(null);
    }

    public IdRecord {
        Objects.requireNonNull(id);
    }

    public static void main(String[] args) {
        IdRecord.NULL_ID.id();
    }
}