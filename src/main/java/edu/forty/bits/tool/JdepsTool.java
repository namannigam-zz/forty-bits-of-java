package com.stackoverflow.nullpointer.tool;

import java.util.Optional;
import java.util.spi.ToolProvider;

public class JdepsTool {

    public static void main(String[] args) {
        Optional<ToolProvider> javac = ToolProvider.findFirst("jdeps");
        int javacRun = javac.get().run(
                System.out,
                System.err,
                "--help"
        );
    }
}