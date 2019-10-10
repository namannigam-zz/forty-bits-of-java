package edu.forty.bits.tool;

import java.util.Optional;
import java.util.spi.ToolProvider;

public class JavaCTool {
    public static void main(String[] args) {
        Optional<ToolProvider> javac = ToolProvider.findFirst("javac");
        int javacRun = javac.get().run(
                System.out,
                System.err,
                "--describe-module",
                "--file",
                "/Users/naman.nigam/.m2/repository/commons-lang3-3.6.jar"
        );
        System.out.println(javacRun);
    }
}