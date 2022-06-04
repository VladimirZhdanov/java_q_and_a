package com.homel.preparation.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class Multithreading {

    static AtomicInteger count = new AtomicInteger(0);
    //int count = 0;

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 20000; i++) {
                //count++;
                count.addAndGet(1);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 20000; i++) {
                //count++;
                count.addAndGet(1);
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(count);
    }
}