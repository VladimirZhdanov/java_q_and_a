package com.homel.preparation.concurrency.blockingqueue.custom;

import com.homel.preparation.concurrency.blockingqueue.java.Message;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private final CustomBlockingQueue<Message> queue;

    public Producer(CustomBlockingQueue<Message> q) {
        this.queue = q;
    }

    @Override
    public void run() {
        //produce messages
        for (int i = 0; i < 100; i++) {
            Message msg = new Message("" + i);
            try {
                Thread.sleep(i);
                queue.put(msg);
                System.out.println("Produced " + msg.getMsg());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //adding exit message
        Message msg = new Message("exit");
        queue.put(msg);
    }

}
