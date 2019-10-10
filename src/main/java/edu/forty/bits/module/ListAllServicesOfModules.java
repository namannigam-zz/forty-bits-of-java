package edu.forty.bits.module;

public class ListAllServicesOfModules {
    public static void main(String[] args) {
        ModuleLayer.boot().modules().stream().map(Module::getDescriptor).filter(md -> !md.provides().isEmpty()).sorted()
                .forEach(md -> System.out.format("%s -> %s%n", md.name(), md.provides()));
    }
}