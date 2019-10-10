package edu.forty.bits.module;

import java.lang.module.Configuration;
import java.lang.module.ModuleDescriptor;
import java.lang.module.ModuleFinder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

public class ModuleGraph {

    public static void main(String[] args) {

        Path path = Paths.get("/Users/naman.nigam/GitHub/Naman/Jigsaw/out/production");

        ModuleFinder finder = ModuleFinder.of(path);

        ModuleLayer parent = ModuleLayer.boot();

        Configuration configuration = parent.configuration().resolve(finder, ModuleFinder.of(), Set.of("modular"));

        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();

        ModuleLayer layer = parent.defineModulesWithOneLoader(configuration, systemClassLoader);


        Module m = ModuleLayer.boot().findModule("my.module").orElse(null);


        Class<?> c = null;
        try {
            c = layer.findLoader("modular").loadClass("com.module.ModularExperiment");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Module module = c.getModule();

        moduleDescription(module);
    }


    private static void moduleDescription(Module module) {
        System.out.println(module.getDescriptor().toString());

        Set<ModuleDescriptor.Requires> requires = module.getDescriptor().requires();
        System.out.println("Requires: " + requires);
        requires.forEach(s -> s.modifiers().forEach(mod -> {
            System.out.println( s + " "  + mod.toString());
        }));

        Set<ModuleDescriptor.Exports> exports = module.getDescriptor().exports();
        System.out.println("Exports: " + exports);
        exports.forEach(s -> s.modifiers().forEach(mod -> {
            System.out.println(mod.toString());
        }));

        Set<ModuleDescriptor.Opens> opens = module.getDescriptor().opens();
        System.out.println("Opens: " + opens);
        opens.forEach(s -> s.modifiers().forEach(mod -> {
            System.out.println(mod.name());
        }));

        Set<ModuleDescriptor.Provides> provides = module.getDescriptor().provides();
        provides.forEach(p -> {
            System.out.println("service - " + p.service());
            System.out.println("providers - " + p.providers());
        });

        Set<ModuleDescriptor.Modifier> modifiers = module.getDescriptor().modifiers();
        System.out.println("Modifiers: " + modifiers);
        modifiers.forEach(mod -> System.out.println(mod.name()));

        String mainClass = module.getDescriptor().mainClass().orElse("None");
        System.out.println("Main Class: " + mainClass);

        boolean automaticModule = module.getDescriptor().isAutomatic();
        System.out.println("Is Automatic: " + automaticModule);

        boolean openModule = module.getDescriptor().isOpen();
        System.out.println("Is Open: " + openModule);

        Set<String> modulePackages = module.getDescriptor().packages();
        System.out.println("Packages: " + modulePackages);

        String moduleName = module.getDescriptor().name();
        System.out.println("Module Name: " + moduleName);

        String rawVersion = module.getDescriptor().rawVersion().orElse("0.0.0");
        System.out.println("Module Version: " + rawVersion);

        String nameAndVersion = module.getDescriptor().toNameAndVersion();
        System.out.println("Module NameAndVersion: " + nameAndVersion);
    }
}