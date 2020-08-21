package edu.forty.bits.exception;

import java.util.concurrent.TimeoutException;

public class ThrowCustomException {

    public static void main(String[] args) {
        // write your code here
        try {
            testException(null);
        } catch (CustomException e) {
            e.calledMethod(e);
        }
    }

    private static void testException(String str) throws CustomException {
        if (str == null) {
            throw new CustomException();
        }
    }

    static class CustomException extends Exception {

        public CustomException() {
            super();
        }

        public void calledMethod(Exception testException) {
            if (testException instanceof TimeoutException) {
                System.out.println("Timeout here...");
            }
            if (testException instanceof NullPointerException) {
                System.out.println("NullPointer here...");
            }
            if (testException instanceof InterruptedException) {
                System.out.println("Interrupted here...");
            }
        }

    }
}