package edu.forty.bits.module;

import java.io.IOException;
import java.lang.module.ModuleDescriptor;
import java.lang.module.ModuleReader;
import java.lang.module.ModuleReference;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

public class ModuleInfo {

    public static void main(String[] args) throws IOException {
        String moduleInfo = "module jdk11udpates {\n" +
                "    requires java.sql;\n" +
                "    requires java.net.http;\n" +
                "}";
        ModuleDescriptor moduleDescriptor = ModuleDescriptor.read(ByteBuffer.wrap(moduleInfo.getBytes()));
        ModuleReference ref = new ModuleReference(moduleDescriptor, Paths.get("").toUri()) {
            @Override
            public ModuleReader open() throws IOException {
                ModuleReader moduleReader = new ModuleReader() {
                    @Override
                    public Optional<URI> find(String name) throws IOException {
                        throw new UnsupportedOperationException("Not supported yet.");
                    }

                    @Override
                    public Stream<String> list() throws IOException {
                        throw new UnsupportedOperationException("Not supported yet.");
                    }

                    @Override
                    public void close() throws IOException {
                        throw new UnsupportedOperationException("Not supported yet.");
                    }
                };
                return moduleReader;
            }
        };
    }
}