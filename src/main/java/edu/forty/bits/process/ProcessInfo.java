package com.stackoverflow.nullpointer.process;

import java.io.IOException;
import java.time.ZoneId;

public class ProcessInfo {

    public static void main(String[] args) throws IOException {
        getInfoTest();
    }

    private static void getInfoTest() throws IOException {
        ProcessBuilder pb = new ProcessBuilder("echo", "Hello World!");
        Process p = pb.start();
        ProcessHandle.Info info = p.info();
        System.out.printf("Process ID: %s%n", p.pid());
        String na = "<not available>";
        System.out.printf("Command name: %s%n", info.command().orElse(na));
        System.out.printf("Command line: %s%n", info.commandLine().orElse(na));

        System.out.printf("Start time: %s%n",
                info.startInstant().map(i -> i.atZone(ZoneId.systemDefault())
                        .toLocalDateTime().toString())
                        .orElse(na));

        System.out.printf("Arguments: %s%n",
                info.arguments().map(a -> String.join(" ", a))
                        .orElse(na));

        System.out.printf("User: %s%n", info.user().orElse(na));
    }
}