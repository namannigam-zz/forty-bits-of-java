package com.stackoverflow.nullpointer.process;

import java.io.IOException;
import java.util.Arrays;

public class DifferentProcess {

    public static void main(String[] args) {
        System.out.println("### Current process info ###");
        ProcessHandle currentProcess = ProcessHandle.current();
        printInfo(currentProcess);

        System.out.println();

        // Fork a child process that lasts for a few seconds
        spawnProcess("jshell --startup ./sleep.txt");

        printAllVisibleProcesses();
    }

    private static void printAllVisibleProcesses() {
        System.out.println("### Visible processes info ###");
        ProcessHandle.allProcesses().forEach(DifferentProcess::printInfo);
        System.out.println();
    }

    private static void spawnProcess(String command) {
        System.out.println("Spawning: " + command);
        try {
            Runtime.getRuntime().exec(command);
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printInfo(ProcessHandle processHandle) {
        ProcessHandle.Info processInfo = processHandle.info();
        System.out.println("Process ID: " + processHandle.pid());

        System.out.println("Process arguments: " + Arrays.toString(processInfo.arguments().orElse(new String[0])));
        System.out.println("Process executable: " + processInfo.command().orElse(""));
        System.out.println("Process command line: " + processInfo.commandLine().orElse(""));
        System.out.println("Process start time: " + processInfo.startInstant().orElse(null));
        System.out.println("Process total cputime accumulated: " + processInfo.totalCpuDuration().orElse(null));
        System.out.println("Process user: " + processInfo.user().orElse(""));
    }

}