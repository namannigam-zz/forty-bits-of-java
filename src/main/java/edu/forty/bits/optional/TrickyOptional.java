package edu.forty.bits.optional;

import java.net.URI;
import java.util.Optional;

public class TrickyOptional {

    public static void main(String... a) {
        Optional<String> prefix = prefix();
        Optional<URI> requirement = prefix.isPresent() ?
                prefix.flatMap(TrickyOptional::findNamespaceByPrefix) : getDefaultNamespace();

        // tempting but incorrect
        Optional<URI> namespace = prefix
                .flatMap(TrickyOptional::findNamespaceByPrefix)
                .or(TrickyOptional::getDefaultNamespace);

        // correct way with wrapping up
        Optional<URI> namespaces = prefix
                .map(str -> findNamespaceByPrefix(str))
                .orElseGet(TrickyOptional::getDefaultNamespace);
    }

    private static Optional<String> prefix() {
        return Optional.of("");
    }

    static Optional<URI> findNamespaceByPrefix(String str) {
        return Optional.empty();
    }

    static Optional<URI> getDefaultNamespace() {
        return Optional.empty();
    }
}