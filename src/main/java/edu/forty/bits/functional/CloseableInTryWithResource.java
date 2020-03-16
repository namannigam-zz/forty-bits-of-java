package edu.forty.bits.functional;

import java.io.Closeable;
import java.io.IOException;

public class CloseableInTryWithResource {

    public static void main(String[] args) {
        String soprano = null;

        CloseIt closeIt = new CloseIt();
        try(closeIt) {
            System.out.println(soprano.matches(null));
        } catch (Exception e) {
            System.out.println("Exception!");
        } catch (Throwable throwable) {
            System.out.println("Throwable!");
        }
    }

    static class CloseIt implements Closeable {
        @Override
        public void close() throws IOException {
            System.out.println("Close..");
        }
    }
}
