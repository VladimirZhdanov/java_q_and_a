package com.homel.preparation.concurrency.typical;

import java.util.Objects;

public class TypicalProblem {
    public static class Test implements Runnable {

        private int counter;

        public void inc() {
            counter++;
        }

        public void dec() {
            counter--;
        }

        public int get() {
            return counter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 4000; i++) {
                inc();
            }
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        new Thread(test).start();

        for (int i = 0; i < 4000; i++) {
            test.dec();
        }

        System.out.println(test.get());
    }
}
