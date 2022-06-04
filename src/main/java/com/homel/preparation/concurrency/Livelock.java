package com.homel.preparation.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Livelock {
    public static void main(String[] args) {
        ReentrantLock lock1 = new ReentrantLock();
        ReentrantLock lock2 = new ReentrantLock();

        Thread t1 = new Thread(() -> {
            while (true) {
                try {
                    lock1.tryLock(50, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T1: acquires the lock1...");
                System.out.println("T1: tries to get the lock2...");

                if (lock2.tryLock()) {
                    System.out.println("T1: acquires the lock2...");
                    lock2.unlock();
                } else {
                    System.out.println("T1: cannot acquires the lock2...");
                    continue;
                }
                break;
            }
            lock1.unlock();
            lock2.unlock();
            System.out.println("T1: end");
        });

        Thread t2 = new Thread(() -> {
            while (true) {
                try {
                    lock2.tryLock(50, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T2: acquires the lock2...");
                System.out.println("T2: tries to get the lock1...");

                if (lock1.tryLock()) {
                    System.out.println("T2: acquires the lock1...");
                    lock1.unlock();
                } else {
                    System.out.println("T2: cannot acquires the lock1...");
                    continue;
                }
                break;
            }
            lock1.unlock();
            lock2.unlock();
            System.out.println("T2: end");
        });

        t1.start();
        t2.start();
    }
}
