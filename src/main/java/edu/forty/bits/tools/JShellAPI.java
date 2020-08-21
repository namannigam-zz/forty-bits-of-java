package edu.forty.bits.tools;

import jdk.jshell.JShell;
import jdk.jshell.tool.JavaShellToolBuilder;

import java.util.List;
import java.util.Locale;

public class JShellAPI {
    private static void printIsEven(int x) {
        System.out.print(x % 2 == 0);
    }

    public static void main(String[] args) {
        trial();
        List<Integer> list = List.of(1, 2, 3, 4, 6, 5, 6);
        list.forEach(JShellAPI::printIsEven);
    }

    public static void trial() {
        java.io.Console console = System.console();
        try (jdk.jshell.JShell js = jdk.jshell.JShell.create()) {
            do {
                System.out.print("Enter some Java code: ");
                String input = console.readLine();
                if (input == null) {
                    break;
                }
                List<jdk.jshell.SnippetEvent> events = js.eval(input);
                for (jdk.jshell.SnippetEvent e : events) {
                    StringBuilder sb = new StringBuilder();
                    if (e.causeSnippet() == null) {
                        //  We have a snippet creation event
                        switch (e.status()) {
                            case VALID:
                                sb.append("Successful ");
                                break;
                            case RECOVERABLE_DEFINED:
                                sb.append("With unresolved references ");
                                break;
                            case RECOVERABLE_NOT_DEFINED:
                                sb.append("Possibly reparable, failed  ");
                                break;
                            case REJECTED:
                                sb.append("Failed ");
                                break;
                        }
                        if (e.previousStatus() == jdk.jshell.Snippet.Status.NONEXISTENT) {
                            sb.append("addition");
                        } else {
                            sb.append("modification");
                        }
                        sb.append(" of ");
                        sb.append(e.snippet().source());
                        System.out.println(sb);
                        if (e.value() != null) {
                            System.out.printf("Value is: %s\n", e.value());
                        }
                        System.out.flush();
                    }
                }
            } while (true);
        }
        System.out.println("\nGoodbye");
    }

    public static void shellBuilderTool() throws Exception {

        JavaShellToolBuilder.builder().run();

        JShell js = JShell.create();
        js.addToClasspath("");
        String modulePath = System.getProperty("jdk.module.path");

        js.eval("System.setProperty(\"jdk.module.path\", \""
                + modulePath + "\");");
        String code = ""
                + "try {"
                + "    Class.forName(\"com.mysql.jdbc.Driver\").newInstance();"
                + "} catch (Exception e) {"
                + "    System.out.println(e.toString());"
                + "}";
        js.eval(code);

        JShell.Builder builder =
                JShell.builder().compilerOptions("--module-path lib", "--add-modules mysql.connector.java");
        JShell jShell = builder.build();

        JavaShellToolBuilder.builder().run();

        JavaShellToolBuilder.builder()
                .run("--feedback", "silent", "MyStart");

        JavaShellToolBuilder.builder()
                .out(null) // streams
                .locale(Locale.ENGLISH)
                .run("--feedback", "silent", "MyStart");
    }
}