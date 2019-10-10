package edu.forty.bits.exception;

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
}