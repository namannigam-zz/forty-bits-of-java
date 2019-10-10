package edu.forty.bits.module;

import java.io.IOException;
import java.lang.module.Configuration;
import java.lang.module.ModuleFinder;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.Set;

public class ModuleCheck {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("/Users/naman.nigam/GitHub/Naman/Jigsaw/out/production/");

        ModuleFinder finder = ModuleFinder.of(path);

        ModuleLayer parent = ModuleLayer.boot();

        parent.modules().forEach(module -> {
            System.out.println(module.getName());
        });

        Configuration configuration = parent.configuration().resolve(finder, ModuleFinder.of(), Set.of("curious"));

        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();

        Enumeration<URL> listofResources =
                systemClassLoader.getResources("/Users/naman.nigam/GitHub/Naman/Jigsaw/out/production/curious");

        while (listofResources.hasMoreElements()) {
            System.out.println(listofResources.nextElement());
        }
        ModuleLayer layer = parent.defineModulesWithOneLoader(configuration, systemClassLoader);

        layer.modules().forEach(module -> {
            System.out.println(module.getName());
        });

        Configuration anotherConf = parent.configuration().resolve(finder, ModuleFinder.of(), Set.of());

        ModuleLayer moduleLayer = parent.defineModulesWithOneLoader(anotherConf, systemClassLoader);

        moduleLayer.modules().forEach(module -> {
            System.out.println(module.getName());
        });


//        System.out.println("Before..");
//        ServiceLoader<ServiceInterface> loader = ServiceLoader.load(ServiceInterface.class, systemClassLoader);
//        for (ServiceInterface serviceInterface : loader) {
//            System.out.println("Service was called");
//            int x = serviceInterface.some();
//            System.out.println(x);
//            serviceInterface.somethingElse();
//        }
//
//        ServiceLoader<ServiceInterface> loader2 = ServiceLoader.loadInstalled(ServiceInterface.class);
//        for (ServiceInterface serviceInterface : loader2) {
//            System.out.println("Service was called");
//            int x = serviceInterface.some();
//            System.out.println(x);
//            serviceInterface.somethingElse();
//        }
//
//        ServiceLoader<ServiceInterface> loader3 = ServiceLoader.load(layer, ServiceInterface.class);
//        for (ServiceInterface serviceInterface : loader3) {
//            System.out.println("Service was called");
//            int x = serviceInterface.some();
//            System.out.println(x);
//            serviceInterface.somethingElse();
//        }
//
//        ServiceLoader<ServiceInterface> loader4 = ServiceLoader.load(ServiceInterface.class, systemClassLoader);
//        for (ServiceInterface serviceInterface : loader4) {
//            System.out.println("Service was called");
//            int x = serviceInterface.some();
//            System.out.println(x);
//            serviceInterface.somethingElse();
//        }
//
//        Set<ServiceInterface> serviceInterfaces =
//                loader.stream().map(ServiceLoader.Provider::get).collect(Collectors.toSet());
//        serviceInterfaces.forEach(serviceInterface -> {
//            System.out.println("Service was called");
//            int x = serviceInterface.some();
//            System.out.println(x);
//            serviceInterface.somethingElse();
//        });
//
//        Iterable<ServiceInterface> its = ServiceLoader.load(ServiceInterface.class);
//        for (ServiceInterface service : its) {
//            System.out.println("Service was called");
//            service.some();
//            service.somethingElse();
//        }
//
//        System.out.println("After..");

// ======================================================================================
        // Emptying the layer to get rid of resources
        layer = ModuleLayer.empty();
        layer.modules().forEach(module -> {
            System.out.println(module.getName());
        });

// ===========================================
    }
}