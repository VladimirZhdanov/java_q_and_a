package com.homel.preparation.concurrency.blockingqueue.custom;

import com.homel.preparation.concurrency.blockingqueue.java.Message;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private final CustomBlockingQueue<Message> queue;

    public Consumer(CustomBlockingQueue<Message> q) {
        this.queue = q;
    }

    @Override
    public void run() {
        try {
            Message msg;
            //consuming messages until exit message is received
            while ((msg = queue.take()).getMsg() != "exit") {
                Thread.sleep(10);
                System.out.println("Consumed " + msg.getMsg());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
