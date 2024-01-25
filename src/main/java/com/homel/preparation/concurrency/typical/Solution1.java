package com.homel.preparation.concurrency.typical;

public class Solution1 {
    public static class Test implements Runnable {

        final Object lock = new Object();

        private int counter;

        public void inc() {
            synchronized (lock) {
                counter++;
            }
        }

        public void dec() {
            synchronized (lock) {
                counter--;
            }
        }

        public int get() {
            return counter;
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
