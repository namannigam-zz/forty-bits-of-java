package edu.forty.bits.jdk09.challenges;

import java.lang.module.ModuleFinder;
import java.lang.module.ModuleReference;
import java.nio.file.Path;
import java.util.Set;
import java.util.stream.Collectors;

public class Challenge14 {

    public static void main(String[] args) {
        /*
         * Get a modue name from the jar file programmitically
         */
        Path dir1 = null;
        ModuleFinder finder = ModuleFinder.of(dir1);
        Set<ModuleReference> moduleReferences = finder.findAll();
        Set<String> moduleNames =
                moduleReferences.stream().map(mr -> mr.descriptor().name()).collect(Collectors.toSet());
    }
}