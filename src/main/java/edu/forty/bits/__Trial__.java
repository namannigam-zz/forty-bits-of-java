package edu.forty.bits;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class __Trial__ {

    @Getter
    @AllArgsConstructor
    static class NPE {
        Integer stat;
        Reason reason;
    }

    @Getter
    static class Reason {
        String detail;
    }

    public static void main(String[] args) throws IOException {
//        JEP-358
//        NPE npe = new NPE(2, null);
//        System.out.println(npe.reason.detail.equalsIgnoreCase("fix"));
        solve();
    }

    static void solve() throws IOException {
    }
}