package com.homel.preparation.concurrency;

import java.util.concurrent.locks.ReentrantLock;

// DeadLock часто происходит когда в обратном порядке захватываем блокировки
// 2й случай - когда notify был использован, но было больше потоков в состоянии wait - возник DeadLock (надо было использовать notifyAll, см. ConcurrencyDemo.class)
//
// Как найти DeadLock:
// Collect thread dump
// jps -l (вывести все запушенные java процессы)
// jstack <pid> | less (id суда пихаем)
public class Deadlock {
    public static void main(String[] args) {
        //deadLock_RL();
        deadLock_Classic();
    }

    public static void deadLock_Classic() {
        Object lock1 = new Object();
        Object lock2 = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 1 acquired lock 1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock2) {
                    System.out.println("Thread 1 acquired lock 2");
                }
            }
            System.out.println("Thread 1: end");
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread 2 acquired lock 2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock1) {
                    System.out.println("Thread 2 acquired lock 1");
                }
            }
            System.out.println("Thread 2: end");
        });

        t1.start();
        t2.start();
    }

    public static void deadLock_RL() {
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
