package com.stackoverflow.nullpointer.module;

import java.lang.module.Configuration;
import java.lang.module.ModuleDescriptor;
import java.lang.module.ModuleFinder;
import java.nio.file.Paths;
import java.util.ServiceLoader;
import java.util.Set;

public class User {

    public static void main(String[] args) {

        ModuleFinder finder = ModuleFinder.of(Paths.get("/Users/naman.nigam/GitHub/Naman/Jigsaw/out/production/"));
        ModuleLayer parent = ModuleLayer.boot();
        Configuration cf = parent.configuration().resolve(finder, ModuleFinder.of(), Set.of("one"));
        ClassLoader scl = ClassLoader.getSystemClassLoader();
        ModuleLayer layer = parent.defineModulesWithManyLoaders(cf, scl);

        layer.modules().stream().map(Module::getDescriptor).map(ModuleDescriptor::requires)
                .forEach(System.out::println);

        ServiceLoader<SomeProvider> someProviders = ServiceLoader.load(SomeProvider.class, scl);
        ServiceLoader<SomeProvider> someProviders1 =
                ServiceLoader.load(SomeProvider.class, ClassLoader.getPlatformClassLoader());

        SomeProvider someProvider = someProviders.iterator().next();

        ServiceLoader<AnotherProvider> anotherProviders = ServiceLoader.load(ModuleLayer.boot(), AnotherProvider.class);
        AnotherProvider anotherProvider = anotherProviders.iterator().next();

        System.out.println("Cool");
    }
}