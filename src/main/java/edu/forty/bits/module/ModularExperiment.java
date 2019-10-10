package com.stackoverflow.nullpointer.module;

import java.lang.module.Configuration;
import java.lang.module.ModuleFinder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class ModularExperiment {

    public static void main(String[] args) throws ClassNotFoundException {
        Path path = Paths.get("/Users/naman.nigam/GitHub/Naman/Jigsaw/out/production");

        ModuleFinder finder = ModuleFinder.of(path);

        ModuleLayer parent = ModuleLayer.boot();

        Configuration configuration = parent.configuration().resolve(finder, ModuleFinder.of(), Set.of("modular"));

        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();

        ModuleLayer layer = parent.defineModulesWithOneLoader(configuration, systemClassLoader);

        System.out.println(layer.boot().modules().stream().map(Module::getName).collect(Collectors.toList()));
        System.out.println(layer.boot().modules().stream().map(Module::getName).collect(Collectors.toList()).size());
        Class<?> c = layer.findLoader("modular").loadClass("com.module.ModularExperiment");

        System.out.println(Arrays.toString(c.getDeclaredFields()));
        System.out.println(Arrays.toString(c.getConstructors()));
    }
}