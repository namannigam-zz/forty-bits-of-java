package edu.forty.bits.functional;

import java.lang.module.ModuleFinder;
import java.lang.module.ModuleReference;
import java.nio.file.Path;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * Get a module name from the jar file programmatically
 */
public class ExtractModuleNameProgrammatically {
    public static void main(String[] args) {
        Path dir1 = null;
        ModuleFinder finder = ModuleFinder.of(dir1);
        Set<ModuleReference> moduleReferences = finder.findAll();
        Set<String> moduleNames = moduleReferences.stream()
                .map(mr -> mr.descriptor().name())
                .collect(Collectors.toSet());
        System.out.println(moduleNames);
    }
}