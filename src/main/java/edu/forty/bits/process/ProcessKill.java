package edu.forty.bits.process;

import java.lang.management.ManagementFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class ProcessKill {

    public static void main(String[] args) {
        Stream<ProcessHandle> currentProcess = ProcessHandle.allProcesses();
        currentProcess.parallel().forEach(processHandle -> {
            System.out.println(processHandle.pid());
            processHandle.destroy();
        });
        System.out.println("current process id:" + currentProcess.toString());
        System.out.println("current process id:" + ManagementFactory.getRuntimeMXBean().getName());

        long pid = Long.MAX_VALUE;
        Optional<ProcessHandle> processHandle = ProcessHandle.of(pid);
        if (processHandle.isPresent()) {
            ProcessHandle.Info processInfo = processHandle.get().info();
            System.out.println("Process arguments: " + Arrays.toString(processInfo.arguments().orElse(new String[0])));
            System.out.println("Process executable: " + processInfo.command().orElse(""));
            System.out.println("Process command line: " + processInfo.commandLine().orElse(""));
            System.out.println("Process start time: " + processInfo.startInstant().orElse(null));
            System.out.println("Process total cputime accumulated: " + processInfo.totalCpuDuration().orElse(null));
            System.out.println("Process user: " + processInfo.user().orElse(""));
        }
    }

    /**
     * get PID of a process
     *
     * @return
     *
     * @throws NoSuchFieldException
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    /*
    public static int getPID() throws Exception {
        RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
        Field jvm = runtime.getClass().getDeclaredField("jvm");
        jvm.setAccessible(true);
        VMManagement mgmt = (sun.management.VMManagement) jvm.get(runtime);
        Method pid_method = mgmt.getClass().getDeclaredMethod("getProcessId");
        pid_method.setAccessible(true);

        return (Integer) pid_method.invoke(mgmt);
    }
    */

}