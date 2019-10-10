package edu.forty.bits;

import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.stream.StreamSupport;

import static java.lang.String.format;

public class ReadingZipFile {


    public static void main(String[] args) {
        final Path zipFile = Paths.get(args[0]);

        System.out.println("Reading zip-file: " + zipFile);
        final URI uri = URI.create("zip:file:" + zipFile.toUri().getPath().replace(" ", "%20"));


        try (final FileSystem fs = zipFile.getFileSystem().provider().newFileSystem(uri, Collections.singletonMap("create", "true"))) {
            final long entriesRead = StreamSupport.stream(fs.getRootDirectories().spliterator(), false)
                    .flatMap(root -> {
                        try {
                            return Files.walk(root);
                        } catch (final IOException ex) {
                            throw new RuntimeException(format(
                                    "Error traversing zip file system '%s', root: '%s'.",
                                    zipFile, root), ex);
                        }
                    }).mapToLong(file -> {
                        try {
                            Files.lines(file).forEachOrdered(System.out::println);
                            return 1;
                        } catch (final IOException ex) {
                            throw new RuntimeException(format(
                                    "Error modifying DAE-file '%s' in zip file system '%s'.",
                                    file, zipFile), ex);
                        }
                    }).sum();

            System.out.format("A total of %,d entries read.%n", entriesRead);

        } catch (final IOException ex) {
            throw new RuntimeException(format(
                    "Error reading zip-file '%s'.", zipFile
            ), ex);
        }
    }
}