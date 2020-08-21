package edu.forty.bits.tools;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class ToolProvision {

    public static void main(String[] args) {
        System.setProperty("java.home", "/Library/Java/JavaVirtualMachines/jdk-9.0.1.jdk/Contents/Home/");
//        System.setProperty("java.home", "/Library/Java/JavaVirtualMachines/jdk-9.0.1.jdk/");
        System.out.println(System.getProperty("java.home")); // print C:\Program Files\Java\jdk-9.0.1
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        System.out.println(compiler.getSourceVersions());
    }
}