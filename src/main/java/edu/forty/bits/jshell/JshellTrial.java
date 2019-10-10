package com.stackoverflow.nullpointer.jshell;

import jdk.jshell.tool.JavaShellToolBuilder;

public class JshellTrial {

    public static void main(String[] args) throws Exception {
        // ======================================================

       JavaShellToolBuilder.builder().run();

        // ======================================================
        // JShell js = JShell.create();
        // js.addToClasspath("");
        // String modulePath = System.getProperty("jdk.module.path");
        //
        // js.eval("System.setProperty(\"jdk.module.path\", \""
        //         + modulePath + "\");");
        // String code = ""
        //         + "try {"
        //         + "    Class.forName(\"com.mysql.jdbc.Driver\").newInstance();"
        //         + "} catch (Exception e) {"
        //         + "    System.out.println(e.toString());"
        //         + "}";
        // js.eval(code);

        // ======================================================

        // JShell.Builder builder =
        //         JShell.builder().compilerOptions("--module-path lib", "--add-modules mysql.connector.java");
        // JShell jShell = builder.build();

        // ======================================================
        // JavaShellToolBuilder.builder().run();
        //
        // JavaShellToolBuilder.builder()
        //         .run("--feedback", "silent", "MyStart");
        //
        // JavaShellToolBuilder.builder()
        //         .out(myCommandPrintStream, myOutputPrintStream)
        //         .locale(Locale.ENGLISH)
        //         .run("--feedback", "silent", "MyStart");
        //
        // JavaShellToolBuilder javaShellToolBuilder = JavaShellToolBuilder.builder().run();
        // ======================================================

    }
}