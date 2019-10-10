package com.stackoverflow.nullpointer.utilities;

import java.io.File;
import java.util.Optional;

public class OptionalOrElse {

    // return true: if present and number of lines != 0
    boolean isValid(File optFile) {
        return Optional.ofNullable(optFile).map(this::isZeroLine).orElse(false);
    }

    boolean isValid(Optional<File> optFile) {
        optFile.ifPresentOrElse(this::doWork, this::doNothing);
        return optFile.filter(this::isZeroLine).isPresent();
    }

    private boolean isZeroLine(File f) {
        return f.canRead();
    }

    private void doWork(File f){

    }

    private void doNothing() {

    }

}
