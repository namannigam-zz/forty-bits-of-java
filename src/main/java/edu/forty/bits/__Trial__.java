package edu.forty.bits;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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

    static void solve() {
    }
}