package com.homel.preparation.concurrency;

public class ConcurrencyDemo {

    private final Object lock = new Object();
    private boolean aBoolean = true;

    public void method1() {
        synchronized (lock) {
            System.out.println("Step 1");
            aBoolean = false;
            lock.notifyAll();
            System.out.println("Step 5");
        }
    }

    // wait приостанавливает выполнение потока, и другой поток может захватить lock и выполнить логику
    // если на lock будет вызван метод notify(), то ждущий поток проснется и продолжит работу
    public void method2() throws InterruptedException {
        synchronized (lock) {
            if (aBoolean) {
                System.out.println("Step 2");
                lock.wait();
                System.out.println("Step 3");
            }
            System.out.println("Step 4");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ConcurrencyDemo demo = new ConcurrencyDemo();
        Thread t1 = new Thread(() -> {
            demo.method1();
        });

        Thread t2 = new Thread(() -> {
            try {
                demo.method2();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                demo.method2();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t2.start();
        t3.start();
        Thread.sleep(1000);
        t1.start();

    }
}
