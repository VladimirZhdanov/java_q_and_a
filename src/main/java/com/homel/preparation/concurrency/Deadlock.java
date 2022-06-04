package com.homel.preparation.concurrency;

import java.util.concurrent.locks.ReentrantLock;

public class Deadlock {
    public static void main(String[] args) {
        ReentrantLock lock1 = new ReentrantLock();
        ReentrantLock lock2 = new ReentrantLock();

        Thread t1 = new Thread(() -> {
            lock1.lock();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T1: get lock2");
            lock2.lock();  // deadlock
            //lock2.tryLock(); // Solution
            System.out.println("T1: end");
        });

        Thread t2 = new Thread(() -> {
            lock2.lock();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T2: get lock1");
            lock1.lock();  // deadlock
            //lock1.tryLock(); // Solution
            System.out.println("T2: end");
        });

        t1.start();
        t2.start();
    }
}
