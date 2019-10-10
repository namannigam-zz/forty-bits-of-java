package edu.forty.bits.module;

import java.io.IOException;
import java.lang.module.ModuleFinder;
import java.lang.module.ModuleReader;
import java.lang.module.ModuleReference;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Set;

public class ModuleReaderTest implements ModuleFinder {

    public static void main(String[] args) {
        ModuleFinder.of(Paths.get("")).findAll().forEach(moduleReference -> {
            try {
                ModuleReader moduleReader = moduleReference.open();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public Optional<ModuleReference> find(String name) {
        return null;
    }

    @Override
    public Set<ModuleReference> findAll() {
        return null;
    }
}