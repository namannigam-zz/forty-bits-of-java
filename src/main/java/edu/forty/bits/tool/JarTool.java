package com.stackoverflow.nullpointer.tool;

import java.util.Optional;
import java.util.spi.ToolProvider;

public class JarTool {

    public static void main(String[] args) {
        Optional<ToolProvider> jar = ToolProvider.findFirst("jar");
        int jarRun = jar.get().run(
                System.out,
                System.err,
                "--describe-module",
                "--file",
                "/Users/naman.nigam/.m2/repository/commons-lang3-3.6.jar"
        );
        System.out.println(jarRun);
    }
}