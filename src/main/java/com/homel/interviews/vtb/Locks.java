package com.homel.interviews.vtb;

public class Locks implements Runnable {
    private Object lock = new Object();

    public void lock() {
        synchronized (lock) {
            try {
                lock.wait();
                System.out.println("1");
            } catch (InterruptedException e) {
            }
        }
    }

    public void unlock() {
        synchronized (lock) {
            lock.notify();
            System.out.println("2");
        }
    }

    public static void main(String s[]) {
        new Thread(new Locks() {
            public void run() {
                lock();
            }
        }).start();
        new Thread(new Locks() {
            public void run() {
                unlock();
            }
        }).start();
    }

    @Override
    public void run() {

    }
}
//программа не завершит работу, на консоли ничего не появится
// 1, 2
// 2, 1
// программа не завершит работу, на консоли появится 1
// программа не завершит работу, на консоли появится 2
// результат трудно предугадать
