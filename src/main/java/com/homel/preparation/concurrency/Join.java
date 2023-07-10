package com.homel.preparation.concurrency;

public class Join {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Runner1();
        Thread t2= new Runner2();

        t1.start();
        t2.start();

        // wait all thread
        t1.join();
        t2.join();

        System.out.println("End");
    }
}

class Runner1 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Runner 1: " + i);
            try {
                Thread.sleep(900);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Runner2 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Runner 2: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}