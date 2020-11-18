package edu.forty.bits.features.records;

public class LocalExample {
    public static void main(String[] args) {
        record Range() {
            Range {
            }
        }
        new Range();
    }
}