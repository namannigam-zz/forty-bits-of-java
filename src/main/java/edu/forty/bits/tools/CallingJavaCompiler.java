package edu.forty.bits.tools;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class CallingJavaCompiler {
    public static void main(String... s) {
        JavaCompiler comp = ToolProvider.getSystemJavaCompiler();
        int i = comp.run(System.in, System.out, System.err, "/Users/naman.nigam/GitHub/Naman/Jigsaw/standalone/src/standalone/standalone/Another.java");
        System.out.println(i);
    }
}