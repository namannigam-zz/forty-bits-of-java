package edu.forty.bits;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public static void main(String[] args) {
//        JEP-358
//        NPE npe = new NPE(2, null);
//        System.out.println(npe.reason.detail.equalsIgnoreCase("fix"));
        solve();
    }

    private static void solve() {
        Set<String> collect = IntStream.range(0, 200)
                .mapToObj(i -> "product" + i)
                .collect(Collectors.toSet());
        new __Trial__().npsTest(collect);
    }

    private void npsTest(Set<String> productIdList) {
        WishlistNPSServiceResponse wishlistNPSServiceResponse = new WishlistNPSServiceResponse();
        List<List<String>> partitionList = Lists.partition(new ArrayList<>(productIdList), 30);
        List<Future<CommandResponse>> futures = new ArrayList<>();
        for (List<String> partition : partitionList) {
            Future<CommandResponse> commandResponseFuture = executeAsyncHttpCall(partition);
            futures.add(commandResponseFuture);
        }

        for (Future<CommandResponse> future : futures) {
            ResponseWrapper<NPSProductResponse> npsHttpResponse = getNpsProductResponse(future);
            wishlistNPSServiceResponse.getNpsProductResponseMap().putAll(npsHttpResponse.getResponse());
            wishlistNPSServiceResponse.getFailedIds().addAll(npsHttpResponse.getFailedIds());
            wishlistNPSServiceResponse.getInvalidIds().addAll(npsHttpResponse.getInvalidIds());
        }
    }

    private ResponseWrapper<NPSProductResponse> getNpsProductResponse(Future<CommandResponse> future) {
        System.out.println("Perform the get here and then type refer to NPSProductResponse:" + future);
        return new ResponseWrapper<>();
    }

    private Future<CommandResponse> executeAsyncHttpCall(List<String> partition) {
        System.out.println("executeAsyncHttpCall" + partition);
        return null;
    }

    @Getter
    class WishlistNPSServiceResponse {
        Map<String, NPSProductResponse> npsProductResponseMap = new HashMap<>();
        Set<String> invalidIds = new HashSet<>();
        Set<String> failedIds = new HashSet<>();
        List<String> info = new ArrayList<>();
    }

    @Getter
    class ResponseWrapper<T> {
        List<String> ids;
        List<String> failedIds;
        List<String> invalidIds;
        Map<String, T> response;
        List<String> info;

        public ResponseWrapper() {
            this.ids = Collections.emptyList();
            this.failedIds = Collections.emptyList();
            this.invalidIds = Collections.emptyList();
            this.response = Collections.emptyMap();
            this.info = Collections.emptyList();
        }
    }

    class CommandResponse {
    }

    class NPSProductResponse {
    }
}