package edu.forty.bits.process;

import java.util.Optional;

public class FilterProcesses {

    public static void main(String[] args) {
        filterProcessesTest();
    }

    private static void filterProcessesTest() {
        Optional<String> currUser = ProcessHandle.current().info().user();
        ProcessHandle.allProcesses()
                .filter(p1 -> p1.info().user().equals(currUser))
                .sorted(FilterProcesses::parentComparator)
                .forEach(FilterProcesses::showProcess);
    }

    private static int parentComparator(ProcessHandle p1, ProcessHandle p2) {
        long pid1 = p1.parent().map(ProcessHandle::pid).orElse(-1L);
        long pid2 = p2.parent().map(ProcessHandle::pid).orElse(-1L);
        return Long.compare(pid1, pid2);
    }

    private static void showProcess(ProcessHandle ph) {
        ProcessHandle.Info info = ph.info();
        System.out.printf("pid: %d, user: %s, cmd: %s%n",
                ph.pid(), info.user().orElse("none"), info.command().orElse("none"));
    }
}