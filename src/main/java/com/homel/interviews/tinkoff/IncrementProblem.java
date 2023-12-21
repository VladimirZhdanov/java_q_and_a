package com.homel.interviews.tinkoff;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IncrementProblem {
    private static int counter1 = 0;
    private static int counter2 = 0;

    public static void main(String[] args) throws InterruptedException {
        int taskCounter = 100_000;
        CountDownLatch latch = new CountDownLatch(taskCounter);
        ExecutorService executor = Executors.newFixedThreadPool(100);

            for (int i = 0; i < taskCounter; i++) {
                executor.submit(() -> {
                    counter1++;
                    counter2++;

                    latch.countDown();
                });
            }

        latch.await();

        System.out.println(counter1);
        System.out.println(counter2);
        System.exit(0);
    }
}
