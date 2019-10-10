package com.stackoverflow.nullpointer.generics;

import java.util.function.BiFunction;
import java.util.function.Function;

public interface Checker<A,B> extends BiFunction<Checker.CheckRequest<A>, Function<A,B>, Checker.CheckResponse<B>> {

    class CheckResponse<B> {
        private B operationResponse;

        public void setOperationResponse(B operationResponse) {
            this.operationResponse = operationResponse;
        }

        public B getOperationResponse() {
            return operationResponse;
        }
    }

    class CheckRequest<A> {
        private A operationRequest;

        public void setOperationRequest(A operationRequest) {
            this.operationRequest = operationRequest;
        }

        public A getOperationRequest() {
            return operationRequest;
        }
    }

    default B execute(A req) {
        CheckRequest<A> chkReq = new CheckRequest<>();
        chkReq.setOperationRequest(req);

        Function<A, B> op = a -> null;

        Checker<A, B> checker = (aCheckRequest, abFunction) -> new CheckResponse<>();

        return checker.apply(chkReq, op).getOperationResponse();
    }
}