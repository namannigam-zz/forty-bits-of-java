package edu.forty.bits.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceSample {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(200);

//        for (int i = 0; i < 200; i++) {
//            if (check == true) {
//                es.submit() -> callTrueAPI();
//            } else {
//                es.submit() -> callFalseAPI();
//            }
//        }
        es.shutdown();


    }
}