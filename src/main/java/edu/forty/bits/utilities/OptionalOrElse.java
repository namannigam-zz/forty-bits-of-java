package edu.forty.bits.utilities;

import java.io.File;
import java.util.Optional;

public class OptionalOrElse {

    boolean isValid(File optFile) {
        Optional.ofNullable(optFile).ifPresentOrElse(this::doWork, this::doNothing);
        return Optional.ofNullable(optFile).filter(this::isZeroLine).isPresent();
    }

    private boolean isZeroLine(File f) {
        return f.canRead();
    }

    private void doWork(File f) {
    }

    private void doNothing() {
    }
}