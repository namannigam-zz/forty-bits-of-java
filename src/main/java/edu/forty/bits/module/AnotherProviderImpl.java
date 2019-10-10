package edu.forty.bits.module;

import java.lang.module.ModuleReference;
import java.util.Optional;
import java.util.Set;

public class AnotherProviderImpl implements AnotherProvider {
    @Override
    public Optional<ModuleReference> find(String name) {
        return Optional.empty();
    }

    @Override
    public Set<ModuleReference> findAll() {
        return null;
    }
}