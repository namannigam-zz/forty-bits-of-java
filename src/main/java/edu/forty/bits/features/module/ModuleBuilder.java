package edu.forty.bits.features.module;

import java.lang.module.ModuleDescriptor;
import java.util.Set;

public class ModuleBuilder {

    public static void main(String[] args) {
        ModuleDescriptor descriptor = ModuleDescriptor.newModule("stats.core")
                .requires("java.base")
                .exports("org.acme.stats.core.clustering")
                .exports("org.acme.stats.core.regression")
                .packages(Set.of("org.acme.stats.core.internal"))
                .build();
    }
}
