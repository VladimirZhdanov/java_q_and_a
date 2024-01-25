package com.homel.preparation.concurrency.typical;

import java.util.concurrent.atomic.AtomicInteger;

public class Solution2 {
    public static class Test implements Runnable {

        private final AtomicInteger counter = new AtomicInteger();

        public void inc() {
            counter.incrementAndGet();
        }

        public void dec() {
            counter.decrementAndGet();
        }

        public int get() {
            return counter.get();
        }

        @Override
        public void run() {
            for (int i = 0; i < 4_000_000; i++) {
                inc();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
        Thread thread = new Thread(test);
        thread.start();

        for (int i = 0; i < 4_000_000; i++) {
            test.dec();
        }

        thread.join();
        System.out.println(test.get());
    }
}
