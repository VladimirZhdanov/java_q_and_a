package com.homel.preparation.concurrency.blockingqueue.custom;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class CustomBlockingQueue<T> {

    private final Queue<T> queue;



    private final Object lock = new Object();

    public CustomBlockingQueue(int initialCapacity) {
        this.queue = new LinkedList<>();
    }

    public void put(T message) {
        synchronized (lock) {
            queue.offer(message);
            lock.notify();
        }
    }

    public T take() throws InterruptedException {
        synchronized (lock) {
            if (queue.isEmpty()) {
                lock.wait();
            }
            return queue.poll();
        }
    }

}
