package edu.forty.bits.jvmci;

import com.sun.management.HotSpotDiagnosticMXBean;
import com.sun.management.VMOption;

import java.lang.management.ManagementFactory;

public class JVMCIQuery {

    public static void main(String[] args) {
        JVMCIQueries();
    }

    private static void JVMCIQueries() {
        // Check if the JDK used supports JVMCI?
        String vm_version = System.getProperty("java.vm.version");
        System.out.printf("java.vm.version = %s%n", vm_version);

        HotSpotDiagnosticMXBean bean = ManagementFactory.getPlatformMXBean(HotSpotDiagnosticMXBean.class);

        // Is JVMCI enabled by default?
        VMOption enableJVMCI = bean.getVMOption("EnableJVMCI");
        System.out.println(enableJVMCI);

        // Is the system using the JVMCI compiler for normal compilations?
        VMOption useJVMCICompiler = bean.getVMOption("UseJVMCICompiler");
        System.out.println(useJVMCICompiler);

        // What compiler is selected?
        String compiler = System.getProperty("jvmci.Compiler");
        System.out.printf("jvmci.Compiler = %s%n", compiler);
    }
}