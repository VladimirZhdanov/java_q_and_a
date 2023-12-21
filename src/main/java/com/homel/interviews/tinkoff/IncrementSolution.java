package com.homel.interviews.tinkoff;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class IncrementSolution {
    private static final AtomicInteger counter1 = new AtomicInteger();
    private static final AtomicInteger counter2 = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        int taskCounter = 100_000;
        CountDownLatch latch = new CountDownLatch(taskCounter);
        ExecutorService executor = Executors.newFixedThreadPool(100);

            for (int i = 0; i < taskCounter; i++) {
                executor.submit(() -> {
                    counter1.incrementAndGet();
                    counter2.incrementAndGet();

                    latch.countDown();
                });
            }

        latch.await();

        System.out.println("result counter1: " + counter1);
        System.out.println("result counter2: " + counter2);
        executor.shutdown();
    }
}
