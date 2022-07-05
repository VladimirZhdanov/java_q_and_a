package com.homel.interviews.ivi;

public class BlockingQueueClassic implements BlockingQueue {
    // Array to store element for CustomBlockingQueue
    final Object[] array = new Object[6];
    private int putIndex, takeIndex;
    private int count;

    private final Object lock = new Object();

    @Override
    public void put(Object x) throws InterruptedException {
        synchronized (lock) {
            while (count == array.length) {
                // Queue is full, producers need to wait
                lock.wait();
            }

            array[putIndex] = x;
            System.out.println("Producing - " + x);
            putIndex++;
            if (putIndex == array.length) {
                putIndex = 0;
            }
            // Increment the count for the array
            ++count;
            lock.notify();
        }
    }

    @Override
    public Object take() throws InterruptedException {
        synchronized (lock) {

            while (count == 0) {
                // Queue is empty, consumers need to wait
                lock.wait();
            }
            Object x = array[takeIndex];
            System.out.println("Consuming - " + x);
            takeIndex++;
            if (takeIndex == array.length) {
                takeIndex = 0;
            }
            // reduce the count for the array
            --count;
            // send signal producer
            lock.notify();
            return x;
        }
    }
}
