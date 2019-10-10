package edu.forty.bits.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

public class Semaphores {

    public static void main(String[] args) {
        givenLoginQueueWhenReachLimitThenBlocked();
    }

    private static void givenLoginQueueWhenReachLimitThenBlocked() {
        int slots = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(slots);
        LoginQueueUsingSemaphore loginQueue = new LoginQueueUsingSemaphore(slots);
        IntStream.range(0, slots).forEach(user -> executorService.execute(loginQueue::tryLogin));
//        executorService.shutdown();
        assert 0 == loginQueue.availableSlots();
        assert !loginQueue.tryLogin();
    }


    static class LoginQueueUsingSemaphore {

        private Semaphore semaphore;

        public LoginQueueUsingSemaphore(int slotLimit) {
            semaphore = new Semaphore(slotLimit);
        }

        boolean tryLogin() {
            return semaphore.tryAcquire();
        }

        void logout() {
            semaphore.release();
        }

        int availableSlots() {
            return semaphore.availablePermits();
        }

    }
}