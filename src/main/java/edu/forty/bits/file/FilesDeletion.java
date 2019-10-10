package edu.forty.bits.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class FilesDeletion {

    public static void main(String[] args) {
        deletFiles();
    }

    private static void deletFiles() {
        List<Path> paths = new ArrayList<>();
        paths.forEach(folderPath -> {
            Path to = folderPath.getRoot().resolve(
                    folderPath.getParent().subpath(0, folderPath.getNameCount() - 1));
            try {
                Files.list(folderPath).forEach(filePath -> {
                    try {
                        Files.move(filePath, to.resolve(filePath.getFileName()), StandardCopyOption.ATOMIC_MOVE);
                    } catch (IOException e) {
                        processException(e);
                    }
                });
                if (Files.list(folderPath).count() == 0) {
                    Files.deleteIfExists(folderPath); // this call
                }
            } catch (IOException e) {
                processException(e);
            }
        });
    }

    private static void processException(IOException e) {
        System.out.println(e.getMessage());
    }
}