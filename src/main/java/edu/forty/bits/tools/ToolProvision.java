package edu.forty.bits.tools;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.util.Optional;

public class ToolProvision {

    public static void main(String[] args) {
        System.setProperty("java.home", "/Library/Java/JavaVirtualMachines/jdk-9.0.1.jdk/Contents/Home/");
//        System.setProperty("java.home", "/Library/Java/JavaVirtualMachines/jdk-9.0.1.jdk/");
        System.out.println(System.getProperty("java.home")); // print C:\Program Files\Java\jdk-9.0.1
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        System.out.println(compiler.getSourceVersions());

        int i = compiler.run(System.in, System.out, System.err,
                "/Users/naman.nigam/GitHub/Naman/Jigsaw/standalone/src/standalone/standalone/Another.java");
        System.out.println(i);
    }

    private static void toolProvider() {
        // jar tool
        Optional<java.util.spi.ToolProvider> jar = java.util.spi.ToolProvider.findFirst("jar");
        int jarRun = jar.get().run(
                System.out,
                System.err,
                "--describe-module",
                "--file",
                "/Users/naman.nigam/.m2/repository/commons-lang3-3.6.jar"
        );
        System.out.println(jarRun);

        // javac tool
        Optional<java.util.spi.ToolProvider> javac = java.util.spi.ToolProvider.findFirst("javac");
        int javacRun = javac.get().run(
                System.out,
                System.err,
                "--describe-module",
                "--file",
                "/Users/naman.nigam/.m2/repository/commons-lang3-3.6.jar"
        );
        System.out.println(javacRun);

        // jdeps tool
        Optional<java.util.spi.ToolProvider> jdeps = java.util.spi.ToolProvider.findFirst("jdeps");
        int jdepsRun = javac.get().run(
                System.out,
                System.err,
                "--help"
        );
    }
}