package com.stackoverflow.nullpointer.jshell;

import java.util.List;

public class JShellExample {
    private static void printIsEven(int x) {
        System.out.print(x%2 ==0);
    }

    public static void main(String[] args) {
        trial();
        List<Integer> list = List.of(1, 2, 3, 4, 6, 5, 6);
        list.forEach(JShellExample::printIsEven);
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
}