package com.homel.preparation.concurrency;

public class HappensBefore {

    private static volatile int value = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                method1();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                method2();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        method2();
        System.out.println("END");
    }

    private static void method1() {
        synchronized (HappensBefore.class) {
            value++;
        }
    }

    private static void method2() {
        synchronized (HappensBefore.class) {
            System.out.println(value);
        }
    }
}
