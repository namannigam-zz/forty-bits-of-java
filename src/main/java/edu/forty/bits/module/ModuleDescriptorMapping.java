package com.stackoverflow.nullpointer.module;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.module.ModuleDescriptor;

public class ModuleDescriptorMapping {

    public static void main(String[] args) {
        ModuleDescriptor moduleDescriptor = null;
        try {
            moduleDescriptor = ModuleDescriptor.read(new FileInputStream(
                    "/Users/naman.nigam/GitHub/Naman/Jigsaw/out/production/standalone/module-info.class"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        if (moduleDescriptor != null) showModuleDescription(moduleDescriptor);
    }

    private static void showModuleDescription(ModuleDescriptor moduleDescriptor) {
        System.out.println("Module Description\n-------------------------");
        System.out.println("Requires: " + moduleDescriptor.requires());
        System.out.println("Exports: " + moduleDescriptor.exports());
        System.out.println("Uses: " + moduleDescriptor.uses());
        System.out.println("Provides: " + moduleDescriptor.provides());
        System.out.println("Packages: " + moduleDescriptor.packages());
    }
}