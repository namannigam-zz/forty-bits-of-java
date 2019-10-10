package edu.forty.bits.module;

import java.io.IOException;
import java.lang.module.Configuration;
import java.lang.module.ModuleFinder;
import java.lang.module.ModuleReference;
import java.lang.module.ResolvedModule;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

public class ModuleToJar {


    public static void main(String[] args) throws IOException {

        Path path = Paths.get("/Users/naman.nigam/GitHub/Naman/Jigsaw/out/production/");

        ModuleFinder finder = ModuleFinder.of(path);

        ModuleLayer parent = ModuleLayer.boot();

        Configuration configuration = parent.configuration().resolve(finder, ModuleFinder.of(), Set.of("commons.lang"));

        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();

        ModuleLayer layer = parent.defineModulesWithOneLoader(configuration, systemClassLoader);

        Module current = layer.findModule("commons.lang").orElse(layer.findModule("modular").orElse(null));

        ModuleReference mref = layer.configuration()
                .findModule("commons.lang")
                .map(ResolvedModule::reference)
                .orElseThrow(() -> new RuntimeException("should not happen"));

        System.out.println(mref.location().orElse(null));
        layer.configuration().modules()
                .forEach(resolvedModule -> System.out.println(resolvedModule.reference().location()));

        System.out.println("For all references on a path.");
        finder.findAll().forEach(moduleReference -> System.out.println(moduleReference.location().orElse(null)));

        Path path2 = Paths.get("/Users/naman.nigam/.m2/repository/");

        ModuleFinder mf = ModuleFinder.of(path2);
        mf.findAll().forEach(moduleReference -> System.out.println(moduleReference.location().orElse(null)));

    }
}