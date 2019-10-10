package edu.forty.bits.functional;

import java.util.function.Supplier;

public class SimpleKeySupplier implements Supplier<String> {
    private final String keyPrefix;
    private final int numToGenerate;
    private int numGenerated;

    public SimpleKeySupplier(String keyPrefix, int numRecs) {
        this.keyPrefix = keyPrefix;
        numToGenerate = numRecs;
        numGenerated = 0;
    }

    @Override
    public String get() {
        if (numGenerated >= numToGenerate) {
            return null;
        } else {
            return (keyPrefix + numGenerated++);
        }
    }
}
